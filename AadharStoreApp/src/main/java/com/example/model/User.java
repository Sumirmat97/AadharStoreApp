package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="aadharNo")
	private Long aadharNo;
	@Column(name="aadharFrontUrl")
	private String aadharFrontUrl;
	@Column(name="aadharBackUrl")
	private String aadharBackUrl;
	@Column(name="createdOn")
	Date createdOn;
	
	public User() {
	}

	public User(Long id, String name, String address, Long aadharNo, String aadharFrontUrl, String aadharBackUrl,
			Date createdOn) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.aadharNo = aadharNo;
		this.aadharFrontUrl = aadharFrontUrl;
		this.aadharBackUrl = aadharBackUrl;
		this.createdOn = createdOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getAadharFrontUrl() {
		return aadharFrontUrl;
	}

	public void setAadharFrontUrl(String aadharFrontUrl) {
		this.aadharFrontUrl = aadharFrontUrl;
	}

	public String getAadharBackUrl() {
		return aadharBackUrl;
	}

	public void setAadharBackUrl(String aadharBackUrl) {
		this.aadharBackUrl = aadharBackUrl;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
}
