package com.cms.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 14-3-1.
 */

@Entity
@Table(name="cms_user")
public class CmsUser {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="user_name")
    private String  userName ;
    private String password;
    @Column(name="create_time")
    private Date createTime;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="last_login_time")
    private Date lastLoginTime;
    private String  status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
