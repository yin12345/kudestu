package com.kude.stu.kudestu.stu.service;


import com.kude.stu.kudestu.stu.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findUserById(Integer id);
    User save(User user);
    User update(User user);
    void delete(int id);
    User login(String username, String password);
    Page<User> findByPage(int page, int limit);


}
