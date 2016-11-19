package com.chen.filter;

import com.chen.controller.IndexController;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by chen on 16-11-15.
 */
public class AuthFilter extends OncePerRequestFilter{

    public static String loginName;//登陆的名称

    public AuthFilter() {
        System.out.println("auth init");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws ServletException, IOException {
        boolean login= this.doLoginCheck(req,resp);
//        if(login)
            filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("end auth filter");
    }

    private boolean doLoginCheck(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String basePath=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath();
        HttpSession httpSession=req.getSession();
        String loginFlag= (String) httpSession.getAttribute(IndexController.userLoginFlag);
        if(loginFlag==null&& StringUtils.isEmpty(loginFlag)){
            if(this.passCheck(req.getServletPath())){
                System.out.println("auth pass");
                return true;
            }
            System.out.println("没有登陆");
            resp.setHeader("Cache-Control", "no-store");
            resp.setDateHeader("Expires", 0);
            resp.setHeader("Prama", "no-cache");
            //跳转到登陆界面
            resp.sendRedirect(basePath+"/home/login");
        }else{
            System.out.println("登陆"+loginFlag);
            loginName=loginFlag;
        }
        return false;
    }

    private boolean passCheck(String servletPath){
        String[] path={
                "home/login",
                "home/index",
                "home/register",
                "index.html",
                "css/",
                "js/"
        };
        if(servletPath=="/") return true;
        for (String p:path){
            if(servletPath.contains(p)){
                return true;
            }
        }
        return false;
    }
}
