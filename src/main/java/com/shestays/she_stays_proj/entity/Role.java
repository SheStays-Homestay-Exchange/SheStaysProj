package com.shestays.she_stays_proj.entity;

import com.shestays.she_stays_proj.common.BaseEntity;

import lombok.Data;

/**
 * 角色
 */
@Data
public class Role extends BaseEntity {

    /**
     * 角色id
     */
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
