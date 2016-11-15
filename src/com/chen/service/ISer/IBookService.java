package com.chen.service.ISer;

import com.chen.entiy.BookBooksEntity;
import com.chen.entiy.BookTypeEntity;

import java.util.List;

/**
 * Created by chen on 16-11-15.
 */
public interface IBookService {
    List getBookListByType(BookTypeEntity bookTypeEntity,int page);
}
