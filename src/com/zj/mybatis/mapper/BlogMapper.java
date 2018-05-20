package com.zj.mybatis.mapper;

import java.util.List;

import com.zj.mybatis.pojo.Blog;

public interface BlogMapper {
	Blog selectBlog(Integer id);
	
	List<Blog> selectBlogByTitle(String title);
	
	List<Blog> selectBlogByTitle2(String title);
}
