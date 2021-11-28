package com.rulesEngine.controller;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rulesEngine.entity.Payment;
import com.rulesEngine.service.PaymentService;

@RestController
@RequestMapping("/Payment")
public class PaymentController {

	@Resource(name = "PaymentService")
	PaymentService paymentService;

	@GetMapping("/getPayment/{id}")
	public Optional<Payment> getPayment(@PathVariable("id") Integer id) {
		return paymentService.getPayment(id);
	}

	@PostMapping("/addPayment")
	public Payment addPayment(@RequestBody Payment payment) {

		return paymentService.addPayment(payment);
	}

	@PutMapping("/updatePayment/{id}")
	public Payment updatePayment(@RequestBody Payment payment) {
		return paymentService.updatePayment(payment);

	}

}
