package com.cms.pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 14-3-18.
 */
@Entity
@Table(name = "cms_role")
public class CmsRole implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

}
