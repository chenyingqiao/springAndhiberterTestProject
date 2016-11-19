package com.chen.repository.IRep;

import java.util.List;

/**
 * Created by chen on 16-11-19.
 */
public interface IBookShopCatRepository<T> extends IBaseRepostitory<T>{
    //取得数据库中所有的购物车的书
    List getAllBookInShopCat();

    void addBookToShopCat(String bookid);

    void delBookFromShopCat(String bookid);

    float countBookShopCat();
    void delAllShopCatBook();
}
