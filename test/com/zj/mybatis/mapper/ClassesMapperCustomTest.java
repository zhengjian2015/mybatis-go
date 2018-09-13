package com.zj.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.zj.mybatis.pojo.Classes;
import com.zj.mybatis.pojo.vo.ClassesCustom;
import com.zj.mybatis.util.MyBatisUtil;


public class ClassesMapperCustomTest {
	private static Logger logger = Logger.getLogger(ClassesMapperCustomTest.class);
	
 	@Test
	public void testSelectClasses() {
		SqlSession session = MyBatisUtil.getSqlsession();
 		ClassesMapperCustom classesMapper = session.getMapper(ClassesMapperCustom.class);
 		ClassesCustom classesCustom = classesMapper.selectClassesById(1);
 		session.close();
 		logger.debug(classesCustom);
	}
}
