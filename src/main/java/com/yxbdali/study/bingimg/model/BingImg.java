package com.yxbdali.study.bingimg.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author xiangbin.yang
 *
 */
@Data
@Entity
public class BingImg {
	@Id
	private Date date;
	private String imgUrl;
	private String copyright;
	private String copyrightUrl;
	private String imgPath;
}
