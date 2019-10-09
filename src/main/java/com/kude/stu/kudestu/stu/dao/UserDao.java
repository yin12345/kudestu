package com.kude.stu.kudestu.stu.dao;



import com.kude.stu.kudestu.stu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,Integer> {

    User findUserById(Integer id);

    //@Query("select id,username,password from user where username=?1 and password=?2")
    // User login(@Param("username") String username, @Param("password") String password);



    //如何两个usernam或者password一样的User用户，回出现500错误
    //这种方法不能用username或者password登入

    @Query(name="login",nativeQuery = true,value =
            "select * from user where username=:username and password=:password")
    User login(@Param("username") String username, @Param("password") String password);

}