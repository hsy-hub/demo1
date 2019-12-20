package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    UserService userService;

    @RequestMapping("/test/{id}")
    @ResponseBody
    public User getUser(@PathVariable(name = "id") Integer id) {
        return userService.getUserByid(id);
    }


    @RequestMapping("/thymeleaf")
    public ModelAndView thymeleaf(Integer id){
        ModelAndView mad = new ModelAndView();
        User user = userService.getUserByid(id);
        mad.addObject("userlist",user);
        mad.setViewName("/UserList.html");
        return mad;
    }
}
