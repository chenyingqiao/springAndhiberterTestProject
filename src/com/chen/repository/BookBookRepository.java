package com.chen.repository;

import com.chen.entiy.BookBooksEntity;
import com.chen.entiy.BookTypeEntity;
import com.chen.repository.IRep.IBookRepository;
import com.chen.repository.IRep.IRepostitoryPage;
import com.chen.service.ISer.IBookService;
import com.sun.istack.internal.Nullable;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by chen on 16-11-15.
 */
@Repository
public class BookBookRepository extends BaseHibernateRepository<BookBooksEntity> implements IBookRepository<BookBooksEntity> {

    /**
     * 获取分页数据
     * @param bookTypeEntity
     * @param page
     * @return
     */
    @Override
    public List getBookListByType(BookTypeEntity bookTypeEntity, int page,@Nullable String bookname) {
        return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(BookBooksEntity.class);
                if(!StringUtils.isEmpty(bookname)){
                    criteria.add(Restrictions.like("name","%"+bookname+"%"));
                    SimpleExpression[] simpleExpressions={Restrictions.like("name","%"+bookname+"%")};
                    BookBookRepository.this.P(criteria,BookBooksEntity.class,page,simpleExpressions);
                }else{
                    BookBookRepository.this.P(criteria,BookBooksEntity.class,page,null);
                }
                //通过类型获取
                if(bookTypeEntity.getId()!=0){
                    criteria.add(Restrictions.eq("type",bookTypeEntity.getId()));
                }
                return criteria.list();
            }
        });
    }

    /**
     * 减少图书数量
     * @param bookid
     */
    @Override
    public boolean minusBook(String bookid){
        if(StringUtils.isEmpty(bookid)){
            return false;
        }
        Integer id=Integer.parseInt(bookid);
        BookBooksEntity bookBooksEntity=this.getOne(BookBooksEntity.class,id);
        int bookNumber=bookBooksEntity.getNumber();
        if(bookNumber==0){
            return false;
        }
        bookNumber--;
        bookBooksEntity.setNumber(bookNumber);
        this.save(bookBooksEntity);
        return true;
    }
}
