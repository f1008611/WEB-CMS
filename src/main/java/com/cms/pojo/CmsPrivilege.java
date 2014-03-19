package com.cms.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 14-3-19.
 */
@Entity
@Table(name="cms_privilege")
public class CmsPrivilege implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String description;
    private String link;
    @Column(name="privilege_name")
    private String privilegeName;
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
