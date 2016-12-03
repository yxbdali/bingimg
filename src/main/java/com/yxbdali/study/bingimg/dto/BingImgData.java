/**
 * 
 */
package com.yxbdali.study.bingimg.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yxbdali.study.bingimg.helper.JsonDateSerializer;

import lombok.Data;

/**
 * @author xiangbin.yang
 * @since 2016年11月11日
 */
@Data
public class BingImgData {
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date date;
	private String copyright;
	private String url;
	private String copyrightlink;
}
