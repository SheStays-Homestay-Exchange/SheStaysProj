package com.shestays.she_stays_proj.common;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BaseEntity implements Serializable {
    /**
     * 创建时间
     */
    // @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/M/dd")
    private Date createTime;
    /**
     * 修改时间
     */
    // @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/M/dd")
    private Date updateTime;
    /**
     * 删除标识
     */
    private Integer isDelete;

}
