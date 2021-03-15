package com.example.dto;

import java.util.Date;

public class UserRequestDTO {

    private String name;
    private String address;
    private Long aadharNo;
    private String aadharFrontUrl;
    private String aadharBackUrl;

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
}
