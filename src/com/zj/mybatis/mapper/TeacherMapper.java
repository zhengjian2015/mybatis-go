package com.zj.mybatis.mapper;

import java.util.List;

import com.zj.mybatis.pojo.Teacher;

public interface TeacherMapper {
	Teacher selectTeacherById(Integer id);
	
	List<Teacher> selectTeachers();
}
