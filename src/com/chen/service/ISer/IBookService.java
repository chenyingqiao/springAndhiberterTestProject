package com.chen.service.ISer;

import com.chen.entiy.BookTypeEntity;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by chen on 16-11-15.
 */
public interface IBookService {
    void indexData(Model model, String typeid, String page,String bookname);
}
