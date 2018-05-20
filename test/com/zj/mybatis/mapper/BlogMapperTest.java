package com.zj.mybatis.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zj.mybatis.pojo.Blog;
import com.zj.mybatis.util.MyBatisUtil;

public class BlogMapperTest{
	
	@Test
	public void testSelectBlognoInterface() {
		SqlSession session = MyBatisUtil.getSqlsession();
			
		Blog blog = (Blog)session.selectOne("com.zj.mybatis.mapper.BlogMapper.selectBlog",3);
		
		session.close();
		
		System.out.println(blog.toString());
	}
	
	@Test
	public void testSelectBlog() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		Blog blog = blogMapper.selectBlog(3);
		
		session.close();
		
		System.out.println(blog.toString());
	}
	
	@Test
	public void testSelectBlogByTitle() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		List<Blog> blogList = blogMapper.selectBlogByTitle("%йт%");
		
		session.close();
		
		System.out.println(blogList.toString());
	}
	
	@Test
	public void testSelectBlogByTitle2() {
		SqlSession session = MyBatisUtil.getSqlsession();
		
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		List<Blog> blogList = blogMapper.selectBlogByTitle2("%йт%");
		
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
} 