package com.chen.controller;

import com.chen.entiy.BookUserEntity;
import com.chen.service.ISer.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.portlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by chen on 16-11-8.
 */
@Controller
@RequestMapping(value = "/home")
public class IndexController extends BaseController {
    public static String userLoginFlag="user_login_session_key";



    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "loginPost",method = RequestMethod.POST)
    public String loginPost(BookUserEntity bookUserEntity, HttpSession httpSession, Model model){
        if(userService.loginCheck(bookUserEntity)){
            httpSession.setAttribute(IndexController.userLoginFlag,userService.getUserInfo(0).getUsername());
            model.addAttribute("msg","登陆成功");
            model.addAttribute("url","/index.html");
            return "success";
        }else{
            model.addAttribute("msg","登陆失败");
            return "error";
        }
    }

    @RequestMapping(value = "/registerPost",method = RequestMethod.POST)
    public ModelAndView registerPost(BookUserEntity bookUserEntity, HttpSession httpSession){
        return null;
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }
}
