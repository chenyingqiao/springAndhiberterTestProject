package com.chen.service;

import com.chen.entiy.BookUserEntity;
import com.chen.filter.AuthFilter;
import com.chen.repository.IRep.IBaseRepostitory;
import com.chen.repository.IRep.IBookRepository;
import com.chen.repository.IRep.IBookShopCatRepository;
import com.chen.repository.IRep.IUserPrepository;
import com.chen.service.ISer.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chen on 16-11-14.
 */
@Service
public class UserService implements IUserService {

    BookUserEntity bookUserEntity;

    @Resource(name = "bookUserRepository")
    IUserPrepository bookUserServiceInPep;

    @Resource(name="bookUserRepository")
    IBaseRepostitory bookUserService;

    @Resource(name = "bookShopCatRepository")
    IBookShopCatRepository bookShopCatRepository;

    @Resource(name="bookBookRepository")
    IBookRepository bookRepository;

    @Override
    public boolean loginCheck(BookUserEntity bookUserEntity) {
        boolean loginStatus= bookUserServiceInPep.loginCheck(bookUserEntity);
        if(loginStatus){
            this.bookUserEntity=bookUserServiceInPep.getUserInfo(0);
        }
        return loginStatus;
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

    @Override
    public void registerUser(BookUserEntity bookUserEntity) {
        this.bookUserService.save(bookUserEntity);
    }

    @Override
    public void ShopCatData(Model model) {
        List list=bookShopCatRepository.getAllBookInShopCat();
        model.addAttribute("login", AuthFilter.loginName);
        model.addAttribute("list",list);
    }

    @Override
    public void ShopCatAdd(String bookid) {
        //减少库存
        boolean minus= bookRepository.minusBook(bookid);
        if(minus==false){
            return;
        }
        //添加图书到购物车
        bookShopCatRepository.addBookToShopCat(bookid);
    }

    @Override
    public float ShopCatClearing() {
        //清空所有的购物车
        float count=  bookShopCatRepository.countBookShopCat();
        bookShopCatRepository.delAllShopCatBook();
        return count;
    }


}
