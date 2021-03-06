package com.chen.repository.IRep;

import com.chen.entiy.BookUserEntity;

/**
 * Created by chen on 16-11-16.
 */
public interface IUserPrepository<T> extends IBaseRepostitory<T> {
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
}
