package com.shestays.she_stays_proj.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("ss_nation")
public class Nation {
    private Integer nationId;
    private String nationName;
    private Integer continentId;
}
