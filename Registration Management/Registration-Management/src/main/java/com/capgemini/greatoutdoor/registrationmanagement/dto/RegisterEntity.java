/****************************************************************************************************************************
 - File Name        : Register Service DTO
 - Author           : Punit Kumar
 - Creation Date    : 13-06-2020
 - Description      : This is an entity class that is used to map the data in the database.
  ****************************************************************************************************************************/

package com.capgemini.greatoutdoor.registrationmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="Register")
public class RegisterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="regId_generator") 
	@SequenceGenerator(name = "regId_generator", initialValue = 1004,allocationSize=1)
	@Column(name="regid")
	private Integer regId;   
	
	@NotBlank(message="Name is mandatory")
	@NotNull(message="Name is mandatory")
	@Column(name="name")
	@Size(min=2,max=30)
	private String name;
	
	@NotBlank(message="Register Type is mandatory")
	@NotNull(message="Register Type is mandatory")
	@Column(name="emptype")
	@Size(min=8,max=20)
	private String emptype;
	
	@NotNull(message="Phone Number is mandatory")
	@Column(name="phnnum")
	private Long phnNum;
	
	@NotBlank(message="Mail is mandatory")
	@NotNull(message="Mail is mandatory")
	@Column(name="mail")
	@Email
	private String mail;
	
	@NotBlank(message="Password is mandatory")
	@NotNull(message="Password is mandatory")
	@Column(name="password")
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
}
