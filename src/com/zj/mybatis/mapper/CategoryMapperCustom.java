package com.zj.mybatis.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zj.mybatis.pojo.Category;
import com.zj.mybatis.pojo.custom.CategoryCustom;



/**
 * Created by ֣��  on 2018/6/16  00:15
 */

public interface CategoryMapperCustom {
	
	
	//���ݷ���id��÷�����Ϣ
	public Category getCategoryById(@Param(value="status") Integer status,@Param(value="id")Integer id) throws Exception;

	

}
