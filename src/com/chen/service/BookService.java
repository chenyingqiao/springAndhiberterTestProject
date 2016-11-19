package com.chen.service;

import com.chen.entiy.BookTypeEntity;
import com.chen.filter.AuthFilter;
import com.chen.repository.IRep.IBookRepository;
import com.chen.repository.IRep.IBookTypeRepository;
import com.chen.service.ISer.IBookService;
import com.chen.service.ISer.IPageInfo;
import com.chen.tool.Page;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 16-11-14.
 */
@Service
public class BookService implements IBookService {


    @Resource(name = "bookBookRepository")
    IBookRepository bookBookRepositoryInSer;

    @Resource(name = "bookBookRepository")
    IPageInfo bookBookRepositoryInPage;

    @Resource(name="bookTypeRepository")
    IBookTypeRepository bookTypeRepositrory;

    @Override
    public void indexData(Model model, String typeid, String page,String search) {
        BookTypeEntity bookTypeEntity=new BookTypeEntity();
        int typeidNum=1,pageNum=1;
        if(typeid==null){typeidNum=0; }else{typeidNum=Integer.parseInt(typeid);}
        if(page==null){pageNum=1;}else{pageNum=Integer.parseInt(page);}
        bookTypeEntity.setId(typeidNum);
        List list=bookBookRepositoryInSer.getBookListByType(bookTypeEntity,pageNum,search);

        List bookTypeList= bookTypeRepositrory.getAllBookType();

        Page pageModel=new Page(this.bookBookRepositoryInPage.getCountPage());
        List<String[]> param=new ArrayList<String[]>();
        String[] baseUrl={"/index.html"};
        param.add(baseUrl);
        if(typeid!=null){
            String[] typeparam={"typeid",typeid};
            param.add(typeparam);
        }
        if(search!=null){
            String[] searcharam={"search",search};
            param.add(searcharam);
        }
        pageModel.push(param,typeidNum);

        //写入用户信息  如果有登陆
        model.addAttribute("login", AuthFilter.loginName);
        model.addAttribute("list",list);
        model.addAttribute("page",pageModel);
        model.addAttribute("bookTypeList",bookTypeList);
    }


}
