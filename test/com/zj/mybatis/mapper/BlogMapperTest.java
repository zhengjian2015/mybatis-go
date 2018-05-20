package com.zj.mybatis.mapper;

import java.util.List;

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
}