package com.shestays.she_stays_proj.vo;

import lombok.Data;

@Data
public class UserReqVo {

    private String code;
    private String encryptedData;
    private String iv;
    private String xhsId;

}
