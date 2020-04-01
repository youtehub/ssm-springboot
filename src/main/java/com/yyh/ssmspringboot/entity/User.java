package com.yyh.ssmspringboot.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     * 主键ID
     */
    @Id
    private Long id;

    /**
     * 用户编码
     */
    private String usercode;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户密码
     */
    private String userpassword;

    /**
     * 性别（1:女、 2:男）
     */
    private Integer gender;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 手机
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户角色（取自角色表-角色id）
     */
    private Long userrole;

    /**
     * 创建者（userId）
     */
    private Long createdby;

    /**
     * 创建时间
     */
    private Date creationdate;

    /**
     * 更新者（userId）
     */
    private Long modifyby;

    /**
     * 更新时间
     */
    private Date modifydate;

    private static final long serialVersionUID = 1L;
}