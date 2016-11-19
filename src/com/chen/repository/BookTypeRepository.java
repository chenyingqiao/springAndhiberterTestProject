package com.chen.repository;

import com.chen.entiy.BookBooksEntity;
import com.chen.entiy.BookTypeEntity;
import com.chen.repository.IRep.IBookTypeRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by chen on 16-11-12.
 */
@Repository
public class BookTypeRepository extends BaseHibernateRepository<BookTypeEntity> implements IBookTypeRepository<BookTypeEntity> {

    @Override
    public List getAllBookType() {
        return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException {
//                return session.createQuery("select new BookTypeEntity() from BookTypeEntity").list();
                    return session.createQuery("from BookTypeEntity ").list();
            }
        });
    }

}
