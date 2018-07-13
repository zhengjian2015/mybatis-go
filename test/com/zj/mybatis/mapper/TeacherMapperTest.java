package com.zj.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.zj.mybatis.pojo.Blog;
import com.zj.mybatis.pojo.Teacher;
import com.zj.mybatis.util.MyBatisUtil;

public class TeacherMapperTest {
	private static Logger logger = Logger.getLogger(TeacherMapperTest.class);
	
	@Test
	public void testSelectTeacher() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		
		Teacher teacher = teacherMapper.selectTeacherById(1);
		
		session.close();
		
		logger.debug(teacher);
	}
	
	@Test
	public void testSelectTeachers() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		
		List<Teacher> teachers = teacherMapper.selectTeachers();
		
		session.close();
		
		logger.debug(teachers);
	}
}
