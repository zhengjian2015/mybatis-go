package com.mybatis.excels;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.zj.mybatis.mapper.BlogMapper;
import com.zj.mybatis.mapper.YsDwzcqkMapper;
import com.zj.mybatis.poj.ReadExcel;
import com.zj.mybatis.pojo.Blog;
import com.zj.mybatis.pojo.YsDwzqk;
import com.zj.mybatis.pojo.YsJbzcb;
import com.zj.mybatis.pojo.ZzRy;
import com.zj.mybatis.util.MyBatisUtil;

public class YzwTest {

	private static Logger logger = Logger.getLogger(YzwTest.class);

	@Test
	public void testSelectYsDwzqkList() {
		SqlSession session = MyBatisUtil.getSqlsession();

		YsDwzcqkMapper ysdwMapper = session.getMapper(YsDwzcqkMapper.class);

		List<YsDwzqk> ysList = ysdwMapper.selectYsDwzqks();
		session.close();

		logger.debug(ysList.size());
	}

	@Test
	public void testInsertList() {
		SqlSession session = MyBatisUtil.getSqlsession();

		YsDwzcqkMapper ysdwMapper = session.getMapper(YsDwzcqkMapper.class);

		ReadExcel read = new ReadExcel();

		File file = new File("C:/Users/zhengj/Desktop/abc.xls");

		List<YsDwzqk> ysList = read.readExcel(file);

		int i = ysdwMapper.insertYsDwzqkList(ysList);
		logger.debug(i);
		session.commit();
		session.close();
	}

	@Test
	public void testInsertList2() {
		SqlSession session = MyBatisUtil.getSqlsession();

		YsDwzcqkMapper ysdwMapper = session.getMapper(YsDwzcqkMapper.class);

		ReadExcel read = new ReadExcel();

		File file = new File("C:/Users/zhengj/Desktop/b.xls");

		List<YsDwzqk> ysList = read.readExcel(file);

		int i = ysdwMapper.insertYsDwzqkList2(ysList);
		logger.debug(i);
		session.commit();
		session.close();

	}

	@Test
	public void testInsertList3() {
		SqlSession session = MyBatisUtil.getSqlsession();

		YsDwzcqkMapper ysdwMapper = session.getMapper(YsDwzcqkMapper.class);

		ReadExcel read = new ReadExcel();

		File file = new File("C:/Users/zhengj/Desktop/c.xls");

		List<YsJbzcb> ysList = read.readExcelSend(file);

		int i = ysdwMapper.insertYsDwzqkList3(ysList);
		logger.debug(i);
		session.commit();
		session.close();

	}

	@Test
	public void testInsertList4() {
		SqlSession session = MyBatisUtil.getSqlsession();

		YsDwzcqkMapper ysdwMapper = session.getMapper(YsDwzcqkMapper.class);

		List<ZzRy> zzRy = ysdwMapper.selectYszzZyqkb();
		for (ZzRy zs : zzRy) {
			String name = zs.getUserName();
			System.out.println(name);
		}
		int a = ysdwMapper.addToYs(zzRy);
		session.commit();
		session.close();

		logger.debug(a);
	}

	@Test
	public void testInsertList6() {
		SqlSession session = MyBatisUtil.getSqlsession();

		YsDwzcqkMapper ysdwMapper = session.getMapper(YsDwzcqkMapper.class);

		List<ZzRy> zzRy = ysdwMapper.selectZzRy();
		int a = 1;
		for (ZzRy zs : zzRy) {
			String zzid = zs.getZzUuid();
			zs.setZzId(a);
			int j = ysdwMapper.updateZzRy(zs);
			a = a + 1;
			System.out.println(j);
		}
		session.commit();
		session.close();
	}

}
