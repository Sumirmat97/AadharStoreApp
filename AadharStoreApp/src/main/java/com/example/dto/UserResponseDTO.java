package com.example.dto;

import java.util.Date;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String address;
    private Long aadharNo;
    private String aadharFrontUrl;
    private String aadharBackUrl;
    private Date createdOn;

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
