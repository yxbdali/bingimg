/**
 * 
 */
package com.yxbdali.study.bingimg.service.impl;

import com.yxbdali.study.bingimg.dao.BingImgRepo;
import com.yxbdali.study.bingimg.model.BingImg;
import com.yxbdali.study.bingimg.service.IBingImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author xiangbin.yang
 * @since 2016年11月11日
 */
@Service
@Transactional
public class BingImgService implements IBingImgService {
	private BingImgRepo bingImgRepo;
	
	@Autowired
	public void setBingImgRepo(BingImgRepo bingImgRepo) {
		this.bingImgRepo = bingImgRepo;
	}

	/* (non-Javadoc)
	 * @see com.yxbdali.study.bingimg.service.IBingImgService#save(com.yxbdali.study.bingimg.model.BingImg)
	 */
	@Override
	public void save(BingImg bingImg) {
		bingImgRepo.save(bingImg);
	}

	@Override
	public void saveBatch(Iterable<BingImg> bingImgs) {
		bingImgRepo.save(bingImgs);
	}

	/* (non-Javadoc)
	 * @see com.yxbdali.study.bingimg.service.IBingImgService#find(java.lang.String)
	 */
	@Override
	public BingImg find(Date date) {
		return bingImgRepo.findOne(date);
	}

	/* (non-Javadoc)
	 * @see com.yxbdali.study.bingimg.service.IBingImgService#findAll()
	 */
	@Override
	public List<BingImg> findAll() {
		return bingImgRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.yxbdali.study.bingimg.service.IBingImgService#find(java.lang.String, java.lang.String)
	 */
	@Override
	public List<BingImg> find(Date startDate, Date endDate) {
		return bingImgRepo.findByDateBetween(startDate, endDate);
	}

}
