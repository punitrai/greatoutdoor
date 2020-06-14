package com.capgemini.greatoutdoor.registrationmanagement.model;

public class Register {

	
	private Integer regId;
	private String name;
	private String emptype;
	private Long phnNum;
	private String mail;
	private String password;
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmptype() {
		return emptype;
	}
	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}
	public Long getPhnNum() {
		return phnNum;
	}
	public void setPhnNum(Long phnNum) {
		this.phnNum = phnNum;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Register [regId=" + regId + ", name=" + name + ", emptype=" + emptype + ", phnNum=" + phnNum + ", mail="
				+ mail + ",passowrd="+password +"]";
	}
}
