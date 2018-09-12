package com.zj.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zj.mybatis.pojo.YsDwzqk;
import com.zj.mybatis.pojo.YsJbzcb;

public interface YsDwzcqkMapper {
	List<YsDwzqk> selectYsDwzqks();
	
	int insertYsDwzqkList(@Param("lists")List<YsDwzqk> lists);
	
	int insertYsDwzqkList2(@Param("lists")List<YsDwzqk> lists);
	
	int insertYsDwzqkList3(@Param("lists")List<YsJbzcb> lists);
}
