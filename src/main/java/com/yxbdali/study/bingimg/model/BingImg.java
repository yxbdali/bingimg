package com.yxbdali.study.bingimg.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * 
 * @author xiangbin.yang
 *
 */
@Data
@Entity
public class BingImg {
	@Id
	private Long id;
	private Date date;
	private String imgUrl;
	private String copyright;
	private String copyrightUrl;
	private String imgPath;

	@ManyToOne
	private Market market;
}
