package com.rulesEngine.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rulesEngine.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
}
