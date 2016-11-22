package com.chen.controller;

import com.chen.entiy.BookUserEntity;
import com.chen.filter.AuthFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.portlet.ModelAndView;

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
    public String loginPost(BookUserEntity bookUserEntity, HttpSession httpSession, Model model,BindingResult result){
        if(StringUtils.isEmpty(bookUserEntity.getUsername())){
            model.addAttribute("msg","请填写用户名");
            model.addAttribute("url","/home/login");
        }
        if(StringUtils.isEmpty(bookUserEntity.getPassword())){
            model.addAttribute("msg","用户名");
            model.addAttribute("url","/home/login");
        }
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
    public String registerPost(BookUserEntity bookUserEntity){
        this.userService.registerUser(bookUserEntity);
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/logoutPost")
    public String logoutPost(HttpSession httpSession){
        AuthFilter.loginName=null;
        httpSession.removeAttribute(IndexController.userLoginFlag);
        return "login";
    }

    @RequestMapping(value = "/shopCat")
    public String shopCat(Model model){
        this.userService.ShopCatData(model);
        return "shopcat";
    }

    @RequestMapping(value = "shopCatAdd")
    public String shopCatAdd(Model model,String bookid){
        model.addAttribute("msg","成功添加到购物车");
        model.addAttribute("url","/index.html");
        this.userService.ShopCatAdd(bookid);
        return "success";
    }

    @RequestMapping(value = "shopCatDel")
    public String shopCatDel(Model model,String bookid){
        model.addAttribute("msg","从购物车成功删除");
        model.addAttribute("url","/home/shopCat");
        this.userService.ShopCatDel(bookid);
        return "success";
    }

    @RequestMapping(value = "shopCount")
    public String shopCount(Model model){
        model.addAttribute("msg","结算成功,总金额："+this.userService.ShopCatClearing());
        model.addAttribute("url","/home/shopCat");
        return "success";
    }
}
