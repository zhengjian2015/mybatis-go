package com.zj.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.zj.mybatis.pojo.Classes;
import com.zj.mybatis.util.MyBatisUtil;

 public class ClassesMapperTest {
	private static Logger logger = Logger.getLogger(ClassesMapperTest.class);
	
 	@Test
	public void testSelectClasses() {
		SqlSession session = MyBatisUtil.getSqlsession();
 		ClassesMapper classesMapper = session.getMapper(ClassesMapper.class);
 		Classes classes = classesMapper.selectClassesById(1);
 		session.close();
 		logger.debug(classes);
	}
 }
