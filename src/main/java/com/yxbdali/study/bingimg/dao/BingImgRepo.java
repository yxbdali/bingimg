/**
 * 
 */
package com.yxbdali.study.bingimg.dao;

import com.yxbdali.study.bingimg.model.BingImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @author xiangbin.yang
 * @since 2016年11月11日
 */
public interface BingImgRepo extends JpaRepository<BingImg, Date> {
	/**
	 * Find all images between start and end date
	 *
	 * @author xiangbin.yang
	 * @since 2016年11月11日
	 * @param start
	 * @param end
	 * @return
	 */
	List<BingImg> findByDateBetween(Date start, Date end);
}
