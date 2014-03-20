package com.cms.service.impl;

import com.cms.dao.BaseDao;
import com.cms.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Administrator on 14-3-20.
 */
@Service
public class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;


    @Override
    public Serializable save(T t) {
        return baseDao.save(t);
    }

    @Override
    public void delete(T t) {
        baseDao.delete(t);
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        baseDao.saveOrUpdate(t);
    }

    @Override
    public T getById(Serializable id) {
        Class<T> c = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return baseDao.getById(c, id);
    }
}
