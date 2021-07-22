package com.wcy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "`order`")
public class Order {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String customerName;

    private String expressType;

    private String expressWeight;

    private String pickupAddress;

    private String receAddress;

    private String pickupInfo;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date releaseTime;

    private String limitTime;

    private String amount;

    private String remarks;

    private String status;

    private String employeeName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date fulfilTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType == null ? null : expressType.trim();
    }

    public String getExpressWeight() {
        return expressWeight;
    }

    public void setExpressWeight(String expressWeight) {
        this.expressWeight = expressWeight == null ? null : expressWeight.trim();
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress == null ? null : pickupAddress.trim();
    }

    public String getReceAddress() {
        return receAddress;
    }

    public void setReceAddress(String receAddress) {
        this.receAddress = receAddress == null ? null : receAddress.trim();
    }

    public String getPickupInfo() {
        return pickupInfo;
    }

    public void setPickupInfo(String pickupInfo) {
        this.pickupInfo = pickupInfo == null ? null : pickupInfo.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime == null ? null : limitTime.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public Date getFulfilTime() {
        return fulfilTime;
    }

    public void setFulfilTime(Date fulfilTime) {
        this.fulfilTime = fulfilTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", expressType='").append(expressType).append('\'');
        sb.append(", expressWeight='").append(expressWeight).append('\'');
        sb.append(", pickupAddress='").append(pickupAddress).append('\'');
        sb.append(", receAddress='").append(receAddress).append('\'');
        sb.append(", pickupInfo='").append(pickupInfo).append('\'');
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", limitTime='").append(limitTime).append('\'');
        sb.append(", amount='").append(amount).append('\'');
        sb.append(", remarks='").append(remarks).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", employeeName='").append(employeeName).append('\'');
        sb.append(", fulfilTime=").append(fulfilTime);
        sb.append('}');
        return sb.toString();
    }
}