package com.yxbdali.study.bingimg.model;/**
 * Created by xiangbin.yang on 2017/1/22.
 */

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author xiangbin.yang
 * @since 2017/1/22
 */
@Data
@Entity
public class Market {
    @Id
    private String mkt;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
    private List<BingImg> bingImgList;
}
