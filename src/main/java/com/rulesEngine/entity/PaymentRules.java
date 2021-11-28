package com.rulesEngine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PaymentRules {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer PaymentRuleId;
	@Column
	private String paymentRuleType;
	@Column
	private String paymentRule;
	

}
