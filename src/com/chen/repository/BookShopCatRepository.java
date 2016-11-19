package com.chen.repository;

import com.chen.entiy.BookBooksEntity;
import com.chen.entiy.BookUserEntity;
import com.chen.entiy.BookUserShopcatEntity;
import com.chen.filter.AuthFilter;
import com.chen.repository.IRep.IBookShopCatRepository;
import com.chen.repository.IRep.IUserPrepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 16-11-19.
 */
@Repository
public class BookShopCatRepository extends BaseHibernateRepository<BookUserShopcatEntity>
        implements IBookShopCatRepository<BookUserShopcatEntity> {

    @Resource(name = "bookUserRepository")
    IUserPrepository userPrepository;

    @Override
    public List getAllBookInShopCat() {
        return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException {
                if(StringUtils.isEmpty(AuthFilter.loginName)){
                    return new ArrayList();
                }
                BookUserEntity user = userPrepository.getUserInfo(AuthFilter.loginName);
                List list= session.createQuery("select bookId from BookUserShopcatEntity bus where bus.userId=:uid").setParameter("uid",user.getId()).list();
                if(list.size()==0){
                    return new ArrayList();
                }
                return session.createCriteria(BookBooksEntity.class).add(Restrictions.in("id",list)).list();
            }
        });
    }

    @Override
    public void addBookToShopCat(String bookid) {
        int id=0;
        if(bookid!=null){id=Integer.parseInt(bookid);}
        if(id==0){return;}
        BookUserShopcatEntity bookUserShopcatEntity=new BookUserShopcatEntity();
        BookUserEntity user= userPrepository.getUserInfo(AuthFilter.loginName);
        bookUserShopcatEntity.setBookId(id);
        bookUserShopcatEntity.setUserId(user.getId());
        this.save(bookUserShopcatEntity);
    }

    @Override
    public void delBookFromShopCat(String bookid) {
        int id=0;
        if(bookid!=null){id=Integer.parseInt(bookid);}
        if(id==0){return;}
        BookUserShopcatEntity bookUserShopcatEntity=new BookUserShopcatEntity();
        BookUserEntity user= userPrepository.getUserInfo(AuthFilter.loginName);
        bookUserShopcatEntity.setBookId(id);
        bookUserShopcatEntity.setUserId(user.getId());
        this.delete(bookUserShopcatEntity);
    }

    @Override
    public float countBookShopCat() {
        List list= this.getAllBookInShopCat();
        float count=0f;
        for (Object bookBooksEntity:list){
            count+=((BookBooksEntity)bookBooksEntity).getPrice();
        }
        return count;
    }

    public void delAllShopCatBook(){
        this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session session) throws HibernateException {
                return session.createQuery("delete from BookUserShopcatEntity bus where 1=1").executeUpdate();
            }
        });
    }

}
