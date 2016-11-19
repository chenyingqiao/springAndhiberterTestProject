package com.chen.repository.IRep;

import com.chen.entiy.BookBooksEntity;
import com.chen.entiy.BookTypeEntity;

import java.util.List;

/**
 * Created by chen on 16-11-16.
 */
public interface IBookRepository<T> extends IBaseRepostitory<T> {
    List getBookListByType(BookTypeEntity bookTypeEntity, int page,String bookname);
    boolean minusBook(String bookid);
}
