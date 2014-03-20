package com.cms.service;

import java.io.Serializable;

/**
 * Created by Administrator on 14-3-20.
 */
public interface BaseService<T> {
    public Serializable save(T t);

    public void delete(T t);

    public void update(T t);

    public void saveOrUpdate(T t);

    public T getById(Serializable id);
}
