package com.rulesEngine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rulesEngine.entity.Payment;
import com.rulesEngine.entity.PaymentRules;
import com.rulesEngine.repo.PaymentRepository;
import com.rulesEngine.repo.PaymentRulesRepository;

@Service("PaymentService")
public class PaymentService {

	@Autowired(required = true)
	PaymentRepository paymentRepository;

	@Autowired(required = true)
	PaymentRulesRepository paymentRulesRepository;

	public Optional<Payment> getPayment(Integer paymentId) {
		return paymentRepository.findById(paymentId);
	}

	public Payment addPayment(Payment payment) {
		// add task/rule to be done/executed for payment made
		addRule(payment);

		return paymentRepository.save(payment);
	}

	private void addRule(Payment payment) {

		List<PaymentRules> rulesList = paymentRulesRepository.findAll();
		for (PaymentRules rules : rulesList) {
			if (rules.getPaymentRule().length() <= 1) {
				if (payment.getPaymentType().equalsIgnoreCase(rules.getPaymentRule())) {
				  compareAndAddRule(payment, payment.getPaymentType(), rules);
				}
			} else {
				String[] ruleTypes = rules.getPaymentRule().split("|");
				for (String ruletype : ruleTypes) {
					if(payment.getPaymentType().equalsIgnoreCase(ruletype)){
					 compareAndAddRule(payment, payment.getPaymentType(), rules);
					}
				}
			}
		}
	}

	private void compareAndAddRule(Payment payment, String ruletype, PaymentRules rules) {
		
			if (payment.getRules()!= null && !payment.getRules().isEmpty()) {
				payment.setRules(payment.getRules() + "," + rules.getPaymentRuleType());
			} else {
				payment.setRules(rules.getPaymentRuleType());
			}

	}

	public Payment updatePayment(Payment payment) {
		Optional<Payment> paymentRecord = paymentRepository.findById(payment.getPaymentId());
		if (paymentRecord != null)
			return paymentRepository.save(payment);
		else
			// To handle Error cases
			return null;
	}
}