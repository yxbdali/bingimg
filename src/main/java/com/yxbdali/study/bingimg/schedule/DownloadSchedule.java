/**
 * 
 */
package com.yxbdali.study.bingimg.schedule;

import com.yxbdali.study.bingimg.bean.Downloader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author xiangbin.yang
 * @since 2016年11月11日
 */
@Slf4j
@Component
public class DownloadSchedule {
	private Downloader downloader;
	@Autowired
	public void setDownloader(Downloader downloader) {
		this.downloader = downloader;
	}
	
	@Scheduled(initialDelay = 10000, fixedDelay = 1000 * 60 * 60 * 6)
	public void downloadBingImgs() throws Exception {
		log.info("Start to download bing images...");
		downloader.download();
		log.info("Dowload bing images finished!");
	}
}
