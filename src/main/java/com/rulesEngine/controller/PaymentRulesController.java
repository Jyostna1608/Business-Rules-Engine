package com.rulesEngine.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rulesEngine.entity.PaymentRules;
import com.rulesEngine.entity.PaymentType;
import com.rulesEngine.service.PaymentRulesService;

@RestController
@RequestMapping("/PaymentRules")
public class PaymentRulesController {

    @Resource(name = "PaymentRulesService")
    PaymentRulesService paymentRulesService;

    @GetMapping("/getPaymentTypes")
    public ResponseEntity<List<PaymentType>> getAllPaymentTypes () {
        List<PaymentType> paymentstype = paymentRulesService.getAllPaymentTypes();
        return new ResponseEntity<List<PaymentType>>(paymentstype, HttpStatus.OK);
    }
    
    @GetMapping("/getPaymentRules")
    public ResponseEntity<List<PaymentRules>> getAllPaymentRules () {
        List<PaymentRules> paymentRules = paymentRulesService.getAllPaymentRules();
        return new ResponseEntity<List<PaymentRules>>(paymentRules, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public Optional<PaymentRules> getPaymentRule(@PathVariable("id") Integer id) {
        Optional<PaymentRules> paymentRules = paymentRulesService.getPaymentRule(id);
        return paymentRules;
    }
    
    @PostMapping("/addPaymentRule")
    public ResponseEntity<MessageResponse> addPaymentRules( @RequestBody PaymentRules paymentRules) {
        PaymentRules newRule = paymentRulesService.addRule(paymentRules);
        return new ResponseEntity<MessageResponse>(HttpStatus.CREATED);
    }

    @PutMapping("/updatePaymentRule")
    public PaymentRules updatePaymentRule(@RequestBody PaymentRules paymentRules) {
        return paymentRulesService.updateRule(paymentRules);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRule(@PathVariable("id") Integer id) {
    	paymentRulesService.deleteRule(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
