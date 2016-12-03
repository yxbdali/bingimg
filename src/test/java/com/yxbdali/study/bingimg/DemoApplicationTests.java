package com.yxbdali.study.bingimg;

import com.yxbdali.study.bingimg.bean.Downloader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
	private Downloader downloader;

	@Test
	public void testDownloader() throws Exception {
		downloader.download();
	}

}
