package com.zj.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.zj.mybatis.pojo.Student;
import com.zj.mybatis.pojo.Teacher;
import com.zj.mybatis.util.MyBatisUtil;

public class StudentMapperTest {
	private static Logger logger = Logger.getLogger(StudentMapperTest.class);

	@Test
	public void testSelectTeachers() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		
		List<Student> students = studentMapper.selectStudentByCid(1);
		
		session.close();
		
		logger.debug(students);
	}

}
