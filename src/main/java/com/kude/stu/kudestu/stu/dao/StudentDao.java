package com.kude.stu.kudestu.stu.dao;


import com.kude.stu.kudestu.stu.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentDao extends JpaRepository<Student,Integer> {

    Student findStudentById(Integer id);

    @Query(name = "findStuByName",nativeQuery = true,value = "select * from student where name=:name")
    List<Student> findStuByName(@Param("name") String name);


}
