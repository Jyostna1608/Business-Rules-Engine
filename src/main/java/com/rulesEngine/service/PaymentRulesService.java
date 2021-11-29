package com.rulesEngine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rulesEngine.entity.PaymentRules;
import com.rulesEngine.entity.PaymentType;
import com.rulesEngine.repo.PaymentTypeRepository;
import com.rulesEngine.repo.PaymentRulesRepository;

@Service("PaymentRulesService")
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

	public Optional<PaymentRules> getPaymentRule(Integer id) {
		return PaymentRulesRepository.findById(id);
	}

	public PaymentRules addRule(PaymentRules paymentRules) {
		return PaymentRulesRepository.save(paymentRules);
	}

	public boolean deleteRule(Integer paymentRulesId) {
		if (PaymentRulesRepository.getById(paymentRulesId)!=null) {
			PaymentRulesRepository.deleteById(paymentRulesId);
			return true;
		}
		return false;
	}
	
	public PaymentRules updateRule(PaymentRules paymentRules) {
		Optional<PaymentRules> paymentRulesReference = PaymentRulesRepository.findById(paymentRules.getPaymentRuleId());
		if (paymentRulesReference!=null)
		return PaymentRulesRepository.save(paymentRules);
		else
			//handle error
		return paymentRules;
	}
}

