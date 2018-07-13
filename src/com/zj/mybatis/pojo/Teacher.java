package com.zj.mybatis.pojo;

public class Teacher {
	private Integer id;
	private String name;
	private Classes classes;
	public Teacher() {
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
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", classes=" + classes + "]";
	}
	
	
}
