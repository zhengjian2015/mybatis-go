package com.zj.mybatis.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.zj.mybatis.pojo.Blog;
import com.zj.mybatis.pojo.Category;
import com.zj.mybatis.pojo.custom.CategoryCustom;
import com.zj.mybatis.util.MyBatisUtil;

public class BlogMapperTest{
	
	private static Logger logger = Logger.getLogger(BlogMapperTest.class);
	
	@Test
	public void testSelectBlognoInterface() {
		SqlSession session = MyBatisUtil.getSqlsession();
			
		Blog blog = (Blog)session.selectOne("com.zj.mybatis.mapper.BlogMapper.selectBlog",3);
		
		
		session.close();
		
		logger.debug(blog);
	}
	
	@Test
	public void testSelectBlog() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		Blog blog2 = blogMapper.selectBlog(3);
		Blog blog3 = blogMapper.selectBlog(3);
		
		session.close();
		
		logger.debug(blog2);
		logger.debug("*****");
		logger.debug(blog3);
	}
	
	@Test
	public void testSelectBlogByTitle() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		List<Blog> blogList = blogMapper.selectBlogByTitle("%试%");
		
		session.close();
		
		System.out.println(blogList.toString());
	}
	
	@Test
	public void testSelectBlogByTitle2() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		List<Blog> blogList = blogMapper.selectBlogByTitle2("%试%");
		
		session.close();
		
		System.out.println(blogList.toString());
	}
	
	@Test
	public void testselectBlogOrderBySort() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		List<Blog> blogList = blogMapper.selectBlogOrderBySort("state");
		
		session.close();
		
		System.out.println(blogList.toString());
	}
	
	@Test
	public void testselectBlogByPage() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		List<Blog> blogList = blogMapper.selectBlogByPage(2, 2);
		
		session.close();
		
		System.out.println(blogList.toString());
	}
	

	@Test
	public void testselectBlogByPage9() throws Exception {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		CategoryMapperCustom categoryMapperCustom = session.getMapper(CategoryMapperCustom.class);
		
		Category cl = categoryMapperCustom.getCategoryById(1, 1);
		
		session.close();
		
		System.out.println(cl);
	}
	
	@Test
	public void testselectBlogByPage2() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		List<Blog> blogList = blogMapper.selectBlogByPage2(1, 3);
		
		session.close();
		
		System.out.println(blogList.toString());
	}
	
	@Test
	public void testselectBlogByPage3() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("offeset", 2);
		map.put("pagesize", 3);
		List<Blog> blogList = blogMapper.selectBlogByPage3(map);
		
		session.close();
		
		System.out.println(blogList.toString());
	}
	
	@Test
	public void testinsertBlog() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		Blog blog = new Blog();
		int counts = blogMapper.insertBlog(blog);
		
		session.commit();
		session.close();
		
		System.out.println(blog);
		System.out.println("插入了"+counts);
	}
	
	@Test
	public void testupdateBlog() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		//Blog blog = new Blog();
		Blog blog = blogMapper.selectBlog(3);
		blog.setId(3);
		blog.setStyle("blue");
		int counts = blogMapper.updateBlog(blog);
		
		session.commit();
		session.close();
		
		System.out.println(blog);
		System.out.println("修改了"+counts);
	}
	
	
	@Test
	public void testCallProc() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		int a = blogMapper.callProcedure();
		
		session.close();
		
		logger.debug(a);
		logger.debug("*****");

	}
} 