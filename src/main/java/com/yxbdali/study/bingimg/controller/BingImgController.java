/**
 * 
 */
package com.yxbdali.study.bingimg.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.yxbdali.study.bingimg.model.BingImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxbdali.study.bingimg.dto.BingImgData;
import com.yxbdali.study.bingimg.service.IBingImgService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import static java.util.stream.Collectors.toList;

/**
 * @author xiangbin.yang
 * @since 2016年11月11日
 */
@Slf4j
@Controller
public class BingImgController {
	//public static final SimpleDateFormat BINGIMGDATEFORMAT = new SimpleDateFormat("yyyyMMddHHmm");

	@Autowired
	private IBingImgService bingImgService;

	@RequestMapping("/all")
	@ResponseBody
	public List<BingImgData> findAll(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		List<BingImgData> bingImgInfoList = new ArrayList<>();
		bingImgService.findAll().forEach(item -> {
			try {
				BingImgData imgData = new BingImgData();
				imgData.setUrl(contextPath + "/images/" + item.getImgPath());
				Date date = item.getDate();
				imgData.setDate(date);
				imgData.setCopyright(item.getCopyright());
				imgData.setCopyrightlink(item.getCopyrightUrl());
				bingImgInfoList.add(imgData);
			} catch (Exception e) {
				log.error(e.toString());
			}
		});

		return bingImgInfoList;
	}

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		List<BingImg> top5ImgList = bingImgService.findAll().stream().sorted((a, b) -> b.getDate().compareTo(a.getDate())).limit(5).collect(toList());
		mv.addObject(top5ImgList);
		return mv;
	}
}
