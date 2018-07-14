package com.zj.mybatis.pojo;

public class Student {
	private Integer id;
	private String name;
	private Integer cid;
	public Student() {
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
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cid=" + cid + "]";
	}
	
	
}
