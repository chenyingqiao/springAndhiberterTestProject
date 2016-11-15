package com.chen.service;

import com.chen.entiy.BookUserEntity;
import com.chen.repository.BookUserRepository;
import com.chen.repository.IRep.IBaseRepostitory;
import com.chen.service.ISer.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chen on 16-11-14.
 */
@Service
public class UserService implements IUserService {

    BookUserEntity bookUserEntity;

    @Resource(name = "bookUserRepository")
    IBaseRepostitory bookUserRepostitory;

    @Resource(name = "bookUserRepository")
    IUserService bookUserServiceInPep;

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
}
