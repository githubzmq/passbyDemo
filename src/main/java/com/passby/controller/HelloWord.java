package com.passby.controller;

import com.passby.entity.User;
import com.passby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HelloWord
 *
 * @author zhangmq
 * @Create 2017-05-10 11:16
 */
@Controller
public class HelloWord {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/helloWord" ,method = RequestMethod.POST)
    public String helloWord(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Hello World!");
        User user = userService.getById(1);
        request.setAttribute("name",user.getUserName());
        System.out.println("name ==" +user.getUserName());
        return "index";
    }

}
