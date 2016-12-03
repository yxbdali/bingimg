package com.yxbdali.study.bingimg.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by xiangbin.yang on 2016/11/11.
 */
@Data
public class BingImgInfo {
    @JsonProperty("fullstartdate")
    private String date;
    private String url;
    private String copyright;
    private String copyrightlink;
}
