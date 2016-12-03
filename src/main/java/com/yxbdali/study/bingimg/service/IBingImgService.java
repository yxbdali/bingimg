/**
 * 
 */
package com.yxbdali.study.bingimg.service;

import com.yxbdali.study.bingimg.model.BingImg;

import java.util.Date;
import java.util.List;


/**
 * @author xiangbin.yang
 * @since 2016年11月11日
 */
public interface IBingImgService {
	/**
	 * Save Bing image to backend database
	 *
	 * @author xiangbin.yang
	 * @since 2016年11月11日
	 * @param bingImg
	 */
	void save(BingImg bingImg);

	/**
	 * Batch save bing images
	 *
	 * @author xiangbin.yang
	 * @param bingImgs
	 */
	void saveBatch(Iterable<BingImg> bingImgs);
	
	/**
	 * Find Bing image by given date string
	 *
	 * @author xiangbin.yang
	 * @since 2016年11月11日
	 * @param date
	 * @return
	 */
	BingImg find(Date date);
	
	/**
	 * Find all bing images
	 *
	 * @author xiangbin.yang
	 * @since 2016年11月11日
	 * @return
	 */
	List<BingImg> findAll();
	
	/**
	 * Find some bing images between start date and end date
	 * 
	 * @author xiangbin.yang
	 * @since 2016年11月11日
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<BingImg> find(Date startDate, Date endDate);
}
