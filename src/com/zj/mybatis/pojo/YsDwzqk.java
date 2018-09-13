package com.zj.mybatis.pojo;

public class YsDwzqk {
	private Integer dwid;
	private String information;
	private String validation;
	private String inputMan;

	public Integer getDwid() {
		return dwid;
	}

	public void setDwid(Integer dwid) {
		this.dwid = dwid;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public String getInputMan() {
		return inputMan;
	}

	public void setInputMan(String inputMan) {
		this.inputMan = inputMan;
	}

	@Override
	public String toString() {
		return "YsDwzqk [dwid=" + dwid + ", information=" + information + ", validation=" + validation + ", inputMan="
				+ inputMan + "]";
	}

}
