package com.zj.mybatis.mapper;

import java.util.List;

import com.zj.mybatis.pojo.Student;


public interface StudentMapper {

	List<Student> selectStudentByCid(Integer id);
}
