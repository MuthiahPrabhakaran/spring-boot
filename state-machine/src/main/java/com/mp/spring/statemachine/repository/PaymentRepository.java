package com.mp.spring.statemachine.repository;

import com.mp.spring.statemachine.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
