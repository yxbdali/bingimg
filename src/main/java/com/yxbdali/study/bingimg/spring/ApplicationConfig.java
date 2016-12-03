/**
 * 
 */
package com.yxbdali.study.bingimg.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author xiangbin.yang
 * @since 2016年11月11日
 */
@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {
	@Value("${bing.img-path}")
	private String imgDir;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations(String.format("file:///%s", imgDir)).setCachePeriod(0);
	}
}
