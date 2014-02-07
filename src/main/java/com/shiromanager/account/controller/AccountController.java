package com.shiromanager.account.controller;

import com.shiromanager.Utils.EncryptUtils;
import com.shiromanager.account.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/18/14
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "login")
public class AccountController {

    @RequestMapping(value = "")
    public String login() {
        String username = "heyaxiang";
        String password = "123456";

        Subject user= SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        token.setRememberMe(true);
        return "views/login";
    }
}
