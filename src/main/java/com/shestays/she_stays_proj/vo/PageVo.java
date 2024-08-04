package com.shestays.she_stays_proj.vo;

import java.util.List;

import com.shestays.she_stays_proj.entity.House;

import lombok.Data;

@Data
public class PageVo {
    /**
     * 当前页
     */
    private Integer pageIndex;
    /**
     * 总页数
     */
    private Integer pageCount;

    private List<House> data;
}
