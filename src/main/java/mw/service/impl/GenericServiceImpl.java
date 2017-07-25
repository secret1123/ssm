package mw.service.impl;

import mw.dao.GenericDao;
import mw.service.GenericService;
import mw.util.Pagination;

import java.io.Serializable;

/**
 * Created by AnLu on
 */
public abstract class GenericServiceImpl<T extends Serializable,ID extends Number> implements GenericService<T,ID> {

    GenericDao<T,ID> genericDao;

    abstract void setGenericDao(GenericDao<T, ID> genericDao);

    @Override
    public void create(T t) {
        genericDao.create(t);
    }

    @Override
    public void remove(ID id) {
        genericDao.remove(id);
    }

    @Override
    public void remove(String statement, Object parameter) {
        genericDao.remove(statement,parameter);
    }

    @Override
    public void modify(T t) {
        genericDao.modify(t);
    }

    @Override
    public void modify(String statement,Object parameter){
        genericDao.modify(statement, parameter);
    }

    @Override
    public T query(String statement, Object parameter) {
        return genericDao.query(statement,parameter);
    }

    @Override
    public T queryById(ID id) {
        return genericDao.queryById(id);
    }

    @Override
    public Pagination<T> query(String statement, Object parameter, int currentPage) {
        return genericDao.query(statement,parameter,currentPage);
    }

    @Override
    public Pagination<T> queryAll(int currentPage) {
        return genericDao.queryAll(currentPage);
    }
}
