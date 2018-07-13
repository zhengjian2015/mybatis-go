package com.zj.mybatis.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zj.mybatis.pojo.Category;
import com.zj.mybatis.pojo.custom.CategoryCustom;



/**
 * Created by 郑健  on 2018/6/16  00:15
 */

public interface CategoryMapperCustom {
	
	
	//根据分类id获得分类信息
	public Category getCategoryById(@Param(value="status") Integer status,@Param(value="id")Integer id) throws Exception;

	

}
