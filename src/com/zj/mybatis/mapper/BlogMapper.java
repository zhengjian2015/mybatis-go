package com.zj.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


import com.zj.mybatis.pojo.Blog;
import com.zj.mybatis.pojo.custom.CategoryCustom;

public interface BlogMapper {
	Blog selectBlog(Integer id);
	
	List<Blog> selectBlogByTitle(String title);
	
	List<Blog> selectBlogByTitle2(String title);
	
	List<Blog> selectBlogOrderBySort(String column);
	
	List<Blog> selectBlogByPage(int offset,int page);
	
	List<Blog> selectBlogByPage2(
			@Param(value="offeset") int offeset,
			@Param(value="pagesize") int pagesize);
	
	List<Blog> selectBlogByPage3(Map<String,Object> map);
	
	int insertBlog(Blog blog);
	
	int updateBlog(Blog blog);
	
	int callProcedure();
	
	public CategoryCustom getCategoryById(@Param(value="status") Integer status,@Param(value="id")Integer id) throws Exception;
}
