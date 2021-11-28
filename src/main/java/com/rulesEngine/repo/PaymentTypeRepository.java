package com.rulesEngine.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rulesEngine.entity.PaymentType;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
	
}
