package com.chen.repository;

import com.chen.entiy.BookUserEntity;
import com.chen.service.ISer.IUserService;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chen on 16-11-14.
 */
@Repository
public class BookUserRepository extends BaseHibernateRepository<BookUserEntity> implements IUserService {

    BookUserEntity bookUserEntity;

    private boolean loginCheck(String username,String password){
        BookUserEntity bookUserEntiy = this.getHibernateTemplate().execute(new HibernateCallback<BookUserEntity>() {
            @Override
            public BookUserEntity doInHibernate(Session session) throws HibernateException {
                Criteria criteria=session.createCriteria(BookUserEntity.class);
                criteria.add(Restrictions.eq("username",username));
                criteria.add(Restrictions.eq("password",password));
                List userlist= criteria.list();
                Object enpty=null;
                if(userlist.size()==0){return null;}
                else{enpty=userlist.get(0);}
                if(enpty==null){
                    return null;
                }else{
                    return (BookUserEntity) enpty;
                }
            }
        });
        if(bookUserEntiy==null){
            return false;
        }else{
            this.bookUserEntity=bookUserEntiy;
            return true;
        }
    }

    @Override
    public boolean loginCheck(BookUserEntity bookUserEntity) {
       return this.loginCheck(bookUserEntity.getUsername(),bookUserEntity.getPassword());
    }

    @Override
    public BookUserEntity getUserInfo(String username) {
        return null;
    }

    @Override
    public BookUserEntity getUserInfo(int uid) {
        if(this.bookUserEntity!=null&&uid==0){
            return this.bookUserEntity;
        }
        return null;
    }

    @Override
    public void updataUserInfo(BookUserEntity bookUserEntity) {

    }

    public BookUserEntity getBookUserEntity() {
        return bookUserEntity;
    }
}
