package com.chen.controller;

import com.chen.service.ISer.IBookService;
import com.chen.service.ISer.IUserService;
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
    public String index(String typeid,String page, String search,Model model){
        bookService.indexData(model,typeid,page,search);
        return "index";
    }
    @RequestMapping(value = "/index.html")
    public String indexDefault(String typeid, String search,String page,Model model){
        return this.index(typeid,page,search,model);
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
