package com.kude.stu.kudestu.stu.service;


import com.kude.stu.kudestu.stu.dao.UserDao;
import com.kude.stu.kudestu.stu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }


    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User update(User user) {
        return userDao.save(user);
    }

    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public Page<User> findByPage(int page, int pageSize) {
        //Pageable pageable = PageRequest.of(page,pageSize,new Sort(Sort.Direction.ASC,"id"));
        Pageable pageable=PageRequest.of(page,pageSize,new Sort(Sort.Direction.ASC,"username"));
        return userDao.findAll(pageable);
    }
}