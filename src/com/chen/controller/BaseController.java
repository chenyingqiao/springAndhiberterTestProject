package com.chen.controller;

import com.chen.entiy.BookTypeEntity;
import com.chen.filter.AuthFilter;
import com.chen.service.ISer.IBookService;
import com.chen.service.ISer.IUserService;
import com.chen.tool.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chen on 16-11-14.
 */
@Controller
@RequestMapping(value = "/")
public class BaseController {

    @Resource(name = "bookService")
    IBookService bookService;

    @Resource(name = "userService")
    IUserService userService;

    @RequestMapping(value = "/")
    public String index(int typeid,int page, Model model){
        BookTypeEntity bookTypeEntity=new BookTypeEntity();
        if(typeid==0){typeid=1; }
        if(page==0){page=1;}
        bookTypeEntity.setId(typeid);
        List list=bookService.getBookListByType(bookTypeEntity,page);
        Page pageModel=new Page();
        pageModel.push("/index.html",page);
        //写入用户信息  如果有登陆
        model.addAttribute("login", AuthFilter.loginName);
        model.addAttribute("list",list);
        model.addAttribute("page",page);
        return "index";
    }
    @RequestMapping(value = "/index.html")
    public String indexDefault(int typeid,int page,Model model){
        return this.index(typeid,page,model);
    }

    protected ModelAndView getNotifyView(String msg,boolean viewChecks){
        String viewname="success";
        if(viewChecks){
            viewname="/WEB-INF/jsp/success.jsp";
        }else{
            viewname="/WEB-INF/jsp/error.jsp";
        }
        ModelAndView modelAndView=new ModelAndView(viewname);
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }
}
