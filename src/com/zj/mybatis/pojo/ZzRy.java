package com.zj.mybatis.pojo;

public class ZzRy {
	private String zzUuid;
	private Integer zzId;
	private String userName;
	private Integer sex;
	private String IdCard;
	private Integer brithDate;
	private Integer jobTime;

	public Integer getZzId() {
		return zzId;
	}

	public void setZzId(Integer zzId) {
		this.zzId = zzId;
	}

	public String getZzUuid() {
		return zzUuid;
	}

	public void setZzUuid(String zzUuid) {
		this.zzUuid = zzUuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return IdCard;
	}

	public void setIdCard(String idCard) {
		IdCard = idCard;
	}

	public Integer getBrithDate() {
		return brithDate;
	}

	public void setBrithDate(Integer brithDate) {
		this.brithDate = brithDate;
	}

	public Integer getJobTime() {
		return jobTime;
	}

	public void setJobTime(Integer jobTime) {
		this.jobTime = jobTime;
	}

	@Override
	public String toString() {
		return "ZzRy [userName=" + userName + ", sex=" + sex + ", IdCard=" + IdCard + ", brithDate=" + brithDate
				+ ", jobTime=" + jobTime + "]";
	}

}
