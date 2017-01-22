/**
 * 
 */
package com.yxbdali.study.bingimg.bean;

import com.yxbdali.study.bingimg.data.BingImgInfo;
import com.yxbdali.study.bingimg.data.BingImgInfoList;
import com.yxbdali.study.bingimg.data.Result;
import com.yxbdali.study.bingimg.model.BingImg;
import com.yxbdali.study.bingimg.service.IBingImgService;
import com.yxbdali.study.bingimg.service.impl.BingImgService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static java.lang.String.format;

/**
 * @author xiangbin.yang
 * @since 2016年11月11日
 */
@Slf4j
@Component
public class Downloader {
	private String bingImgUrl;
	@Value("${bing.img-url}")
	public void setBingImgUrl(String bingImgUrl) {
		this.bingImgUrl = bingImgUrl;
	}

	private String bingImgDir;
    @Value("${bing.img-path}")
    public void setBingImgDir(String bingImgDir) { this.bingImgDir = bingImgDir; }

    private IBingImgService bingImgService;
    @Autowired
    public void setBingImgService(IBingImgService bingImgService) {
        this.bingImgService = bingImgService;
    }

	public static final ExecutorService DOWNLOADIMGTHREADPOOL = Executors.newFixedThreadPool(10);

    /**
     * Donwload images
     *
     * @author xiangbin.yang
     * @throws Exception
     */
	public void download() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
        BingImgInfoList imgInfoList = restTemplate.getForObject(bingImgUrl, BingImgInfoList.class);
		final List<Future<Result>> downloadResultFutureList = new ArrayList<>();

		imgInfoList.getBingImgList().forEach(imgInfo -> {
			downloadResultFutureList.add(DOWNLOADIMGTHREADPOOL.submit(new Download(imgInfo, bingImgDir, bingImgService)));
		});

        downloadResultFutureList.forEach(it -> {
            try {
                Result result = it.get();
                log.info(format("Download '%s' ", result.getUrl()) + (result.isSuccess() ? "pass" : "fail"));
            } catch (InterruptedException | ExecutionException e) {
                log.error(e.toString());
            }
        });
	}
}

@Slf4j
class Download implements Callable<Result> {
    private DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");

	private BingImgInfo imgInfo;
	private IBingImgService bingImgService;
	private String bingImgDir;
	/**
	 * 
	 */
	public Download(BingImgInfo bingImgInfo, String bingImgDir, IBingImgService bingImgService) {
		imgInfo = bingImgInfo;
		this.bingImgService = bingImgService;
		this.bingImgDir = bingImgDir;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Result call() throws Exception {
		String url = "http://www.bing.com" + imgInfo.getUrl();
        String copyright = imgInfo.getCopyright();
        String dateStr = imgInfo.getDate();
        String imgName = FilenameUtils.getName(url);
        String downName = format("%s-%s", dateStr, imgName);
        File downLoadFile = Paths.get(bingImgDir, downName).toFile();
        if (!downLoadFile.exists()) {
            log.info(format("Start to download %s, '%s' at '%s'", dateStr, copyright, url));
            FileUtils.copyURLToFile(new URL(url), downLoadFile);
        }

        Date date = dateFormat.parse(dateStr);
        if (bingImgService.find(date) == null) {
            BingImg bingImg = new BingImg();
            bingImg.setDate(date);
            bingImg.setImgUrl(url);
            bingImg.setImgPath(downName);
            bingImg.setCopyright(copyright);
            bingImg.setCopyrightUrl(imgInfo.getCopyrightlink());

            bingImgService.save(bingImg);
        }
		return new Result(url, true);
	}
	
}
