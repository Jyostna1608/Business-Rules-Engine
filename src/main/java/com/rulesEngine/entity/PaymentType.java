package com.rulesEngine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PaymentType {
	
	@Id
	private Integer payentTypeId;
	
	@Column
	private String paymentType;

	public Integer getPayentTypeId() {
		return payentTypeId;
	}

	public void setPayentTypeId(Integer payentTypeId) {
		this.payentTypeId = payentTypeId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	
	
}
