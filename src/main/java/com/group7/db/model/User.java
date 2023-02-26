package com.group7.db.model;

import javax.annotation.Generated;

public class User {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.id")
    private String id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.open_id")
    private String openId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.gmt_create")
    private String gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.gmt_modified")
    private String gmtModified;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.id")
    public String getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.id")
    public void setId(String id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.open_id")
    public String getOpenId() {
        return openId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.open_id")
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.gmt_create")
    public String getGmtCreate() {
        return gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.gmt_create")
    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.gmt_modified")
    public String getGmtModified() {
        return gmtModified;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-02-26T18:48:17.9625468+08:00", comments="Source field: User.gmt_modified")
    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }
}