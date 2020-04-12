package com.car.violation.management.entity;


import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@ToString
@Component
public class Announcement {

    /**
     *编号
     */
    private String ID;
    /**
     *标题
     */
    private String title;
    /**
     *内容
     */
    private String content;
    /**
     *创建人
     */
    private String founder;
    /**
     *创建人账号
     */
    private String founderAccount;
    /**
     *关键字
     */
    private String keywords;
    /**
     *创建日期
     */
    private Date createDate;
    /**
     *更新日期
     */
    private Date updateDate;
}
