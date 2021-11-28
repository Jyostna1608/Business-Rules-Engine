package com.rulesEngine.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rulesEngine.entity.PaymentRules;

@Repository
public interface PaymentRulesRepository extends JpaRepository<PaymentRules, Integer> {
	
}
