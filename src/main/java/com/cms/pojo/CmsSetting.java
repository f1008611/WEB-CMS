package com.cms.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 14-4-9.
 */
@Entity
@Table(name = "cms_setting")
public class CmsSetting implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
