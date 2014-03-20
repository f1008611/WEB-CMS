package com.cms.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-2-27.
 */
public interface BaseDao<T> {

    public Serializable save(T t);

    public void delete(T t);

    public void update(T t);

    public void saveOrUpdate(T t);

    public T get(String hql);

    public T get(String hql, Map<String, Object> params);

    public List<T> find(String hql);

    public List<T> find(String hql, Map<String, Object> params);

    public List<T> find(String hql, int page, int rows);

    public List<T> find(String hql, Map<String, Object> params, int page, int rows);

    public Long count(String hql);

    public Long count(String hql, Map<String, Object> params);

    public T getById(Class<T> c, Serializable id);
}
