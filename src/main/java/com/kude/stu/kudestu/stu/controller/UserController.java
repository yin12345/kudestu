package com.kude.stu.kudestu.stu.controller;


import com.kude.stu.kudestu.stu.entity.User;
import com.kude.stu.kudestu.stu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 处理用户信息的控制层
 * @author cxf
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户的方法
     */
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    /**
     * 根据ID查询用户
     */
    @RequestMapping("/query")
    public User findById(int id){
        return userService.findUserById(id);
    }

    /**
     * 注册用户
     */
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public User reg(User user){
        return userService.save(user);
    }

    /**
     * 用户登陆
     */
    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    //public User login(String username,String password){
    //return userService.login(username,password);
    //  }


    /**
     * 用户登陆
     */
    @PostMapping("/login")
    public User login(String username,String password){
        return userService.login(username,password);
    }


    //这个分页还是没用判断好，如果页数p超过3以后，回返回全部是空值
    //应对超越页码数的进行限制一下
    /**
     * 分页查询
     */
    @RequestMapping("/page")
    public Page<User> findByPage(Integer p, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        if(p==null || p<=0){
            p = 0;
        }else{
            p-=1;
        }
        return userService.findByPage(p,2);
    }

    /**
     * 修改
     */
    @RequestMapping("/updata")
    public User update(User user){
        return userService.update(user);
    }

    /**
     * 删除
     */
    @RequestMapping("/del")
    public String del(int id){
        userService.delete(id);
        return "yes";
    }
}
