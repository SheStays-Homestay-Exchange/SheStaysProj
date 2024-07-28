package com.shestays.she_stays_proj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shestays.she_stays_proj.common.BaseEntity;

import lombok.Data;

/**
 * 角色
 */
@Data
@TableName("ss_role")
public class Role extends BaseEntity {

    /**
     * 角色id
     */
    @TableId(type = IdType.AUTO)
    private Integer roleId;
    /**
     * 角色code
     */
    private String roleDictCode;
    /**
     * 角色描述
     */
    private String roleDesc;
}
