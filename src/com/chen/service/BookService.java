package com.chen.service;

import com.chen.entiy.BookTypeEntity;
import com.chen.repository.BookTypeRepository;
import com.chen.repository.IRep.IBaseRepostitory;
import com.chen.service.ISer.IBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chen on 16-11-14.
 */
@Service
public class BookService implements IBookService {

    @Resource(name = "bookTypeRepository")
    IBaseRepostitory bookTypeRepository;

    @Resource(name = "bookBookRepository")
    IBookService bookBookRepositoryInSer;

    @Override
    public List getBookListByType(BookTypeEntity bookTypeEntity, int page) {
        return this.bookBookRepositoryInSer.getBookListByType(bookTypeEntity,page);
    }
}
