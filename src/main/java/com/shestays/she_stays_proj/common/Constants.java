package com.shestays.she_stays_proj.common;

public class Constants {
    /**
     * 待审核(房源待发布)
     */
    public static final String STATUS_UPLOADING = "pending_view";
    /**
     * 审核中
     */
    public static final String STATUS_UNDERVIEW = "reviewing";
    /**
     * 已上线
     */
    public static final String STATUS_ONLINE = "online";
    /**
     * 未通过
     */
    public static final String STATUS_NOPASS = "not_approved";
    /**
     * 已下线
     */
    public static final String STATUS_OFFLINE = "offline";

    /**
     * 最大条数
     */
    public final static Integer pageSize = 50;

}
