package com.chen.repository;

import com.chen.repository.IRep.IBaseRepostitory;
import com.chen.repository.IRep.IRepostitoryPage;
import com.sun.istack.internal.Nullable;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by chen on 16-11-12.
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public abstract class BaseHibernateRepository<T> extends HibernateDaoSupport implements IBaseRepostitory<T>,IRepostitoryPage {

    @Autowired
    public void setSessionFactoryNow(SessionFactory sessionFactory){
        this.setSessionFactory(sessionFactory);
    }

    public void save(T entiy){
        this.getHibernateTemplate().save(entiy);
    }

    @Override
    public void save(T[] entiy) {
        for (T bookTypeEntity:entiy){
            this.save(bookTypeEntity);
        }
    }

    @Override
    public void delete(T entiy) {
        this.getHibernateTemplate().delete(entiy);
    }

    @Override
    public void delete(T[] entiy) {
        for (T bookTypeEntity:entiy){
            this.delete(bookTypeEntity);
        }
    }

    @Override
    public void update(T entiy) {
        this.getHibernateTemplate().update(entiy);
    }

    @Override
    public void update(T[] entiy) {
        for (T bookTypeEntity:entiy){
            this.update(bookTypeEntity);
        }
    }

    @Override
    public T getOne(Class<T> bookTypeEntityClass, @Nullable Serializable primaryKey) {
        if(primaryKey==null){
            return null;
        }
        return this.getHibernateTemplate().get(bookTypeEntityClass,primaryKey);
    }

    /**
     * 处理计算页面
     * @param c
     * @param classs
     * @param page
     */
    @Override
    public Long P(Criteria c, Class classs, int page) {
        int pageSize=10;

        Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(classs);
        criteria.setProjection(Projections.rowCount());
        Long count=(Long) criteria.uniqueResult();//获取总行数
        Long pageCount=count/pageSize;

        c.setFirstResult((page-1)*pageSize+1);
        c.setMaxResults(pageSize);
        return count;
    }
}
