package com.yxbdali.study.bingimg.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by xiangbin.yang on 2016/11/11.
 */
@Data
public class BingImgInfoList {
    @JsonProperty("images")
    private List<BingImgInfo> bingImgList;
}
