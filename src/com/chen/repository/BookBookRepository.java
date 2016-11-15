package com.chen.repository;

import com.chen.entiy.BookBooksEntity;
import com.chen.entiy.BookTypeEntity;
import com.chen.service.ISer.IBookService;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chen on 16-11-15.
 */
@Repository
public class BookBookRepository extends BaseHibernateRepository<BookBooksEntity> implements IBookService {

    /**
     * 获取分页数据
     * @param bookTypeEntity
     * @param page
     * @return
     */
    @Override
    public List getBookListByType(BookTypeEntity bookTypeEntity, int page) {
        return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(BookBooksEntity.class);
                BookBookRepository.this.P(criteria,BookBooksEntity.class,page);
                //通过类型获取
                criteria.add(Restrictions.eq("type",bookTypeEntity.getId()));
                return criteria.list();
            }
        });
    }
}
