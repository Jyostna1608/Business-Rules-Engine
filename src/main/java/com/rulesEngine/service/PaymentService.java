package com.rulesEngine.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.rulesEngine.entity.Payment;
import com.rulesEngine.repo.PaymentRepository;

public class PaymentService {
	
	@Autowired(required = true)
	PaymentRepository paymentRepository;
	
	public Optional<Payment> getPayment(Integer paymentId) {
		return paymentRepository.findById(paymentId);
	}

	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	public Payment updatePayment(Payment payment) {
		Optional<Payment> paymentRecord = paymentRepository.findById(payment.getPayentId());
		if(paymentRecord!=null)
			return paymentRepository.save(payment);
		else 
			//To handle Error cases
			return null;
	}
}
