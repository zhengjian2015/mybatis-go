package com.zj.mybatis.pojo;

public class Classes {
	private Integer id;
	private String name;

	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + "]";
	}
	
	
}
