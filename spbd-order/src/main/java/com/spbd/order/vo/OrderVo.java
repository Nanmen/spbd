package com.spbd.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.spbd.wsapi.user.response.UserResponse;

public class OrderVo implements Serializable{

	private static final long serialVersionUID = -6527140874120649415L;

	private Integer id;

	private Date createTime;

	private Date updateTime;

	private Integer productId;

	private UserResponse userInfo;

	private BigDecimal amount;

	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public UserResponse getUserInfo() {
		return userInfo;
	}
	
	public void setUserInfo(UserResponse userInfo) {
		this.userInfo = userInfo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
}
