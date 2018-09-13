package com.zj.mybatis.pojo;

import java.util.List;

public class Classes {
	private Integer id;
	private String name;
	private List<Student> students;

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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
}
