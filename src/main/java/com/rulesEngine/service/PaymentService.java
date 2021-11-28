package com.rulesEngine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rulesEngine.entity.Payment;
import com.rulesEngine.entity.PaymentRules;
import com.rulesEngine.repo.PaymentRepository;
import com.rulesEngine.repo.PaymentRulesRepository;

@Service("PaymentServiceImpl")
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
			if (rules.getPaymentRuleType().length() < 1) {
				compareAndAddRule(payment, payment.getPaymentType(), rules);
			} else {
				String[] ruleTypes = rules.getPaymentRuleType().split("|");
				for (String ruletype : ruleTypes) {
					compareAndAddRule(payment, ruletype, rules);
				}
			}
		}
	}

	private void compareAndAddRule(Payment payment, String ruletype, PaymentRules rules) {
		if (payment.getPaymentType().equalsIgnoreCase(ruletype)) {
			if (!payment.getRules().isEmpty()) {
				payment.setRules("," + rules.getPaymentRule());
			} else {
				payment.setRules(rules.getPaymentRule());
			}
		}

	}

	public Payment updatePayment(Payment payment) {
		Optional<Payment> paymentRecord = paymentRepository.findById(payment.getPayentId());
		if (paymentRecord != null)
			return paymentRepository.save(payment);
		else
			// To handle Error cases
			return null;
	}
}
