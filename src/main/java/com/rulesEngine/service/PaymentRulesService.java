package com.rulesEngine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rulesEngine.entity.PaymentRules;
import com.rulesEngine.entity.PaymentType;
import com.rulesEngine.repo.PaymentTypeRepository;
import com.rulesEngine.repo.PaymentRulesRepository;

//TODO: Implement service class
public class PaymentRulesService {

	@Autowired(required = true)
	PaymentTypeRepository paymentTypeRepository;
	
	@Autowired(required = true)
	PaymentRulesRepository PaymentRulesRepository;
	
	public List<PaymentType> getAllPaymentTypes() {
		return paymentTypeRepository.findAll();
	}
	
	public List<PaymentRules> getAllPaymentRules() {
		return PaymentRulesRepository.findAll();
	}

	public PaymentRules getPaymentRule() {
		return null;
	}

	public PaymentRules addRule() {
		return null;
	}

	public PaymentRules deleteRule() {
		return null;
	}
	
	public PaymentRules updateRule() {
		return null;
	}
}
