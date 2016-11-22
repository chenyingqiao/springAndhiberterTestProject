package com.chen.service.ISer;

import com.chen.entiy.BookUserEntity;
import org.springframework.ui.Model;

/**
 * Created by chen on 16-11-14.
 */
public interface IUserService {
    /**
     * 登陆检查
     * @param bookUserEntity
     * @return
     */
    boolean loginCheck(BookUserEntity bookUserEntity);
    /**
     * 获取用户信息
     * @param username
     * @return
     */
    BookUserEntity getUserInfo(String username);

    /**
     * 获取用户信息
     *
     * @param uid  如果变量中已经有用户的数据就直接返回用户数据
     * @return
     */
    BookUserEntity getUserInfo(int uid);

    /**
     * 修改用户信息
     * @param bookUserEntity
     */
    void updataUserInfo(BookUserEntity bookUserEntity);

    /**
     * 用户注册
     * @param bookUserEntity
     */
    void registerUser(BookUserEntity bookUserEntity);

    void ShopCatData(Model model);

    void ShopCatAdd(String bookid);

    void ShopCatDel(String bookid);

    float ShopCatClearing();
}
