package com.mp.spring.statemachine.service;

import com.mp.spring.statemachine.domain.Payment;
import com.mp.spring.statemachine.repository.PaymentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @Test
    void preAuth() {
        Payment savedPayment = paymentService.newPayment(payment);
        Assertions.assertEquals("NEW", savedPayment.getState().toString());

        paymentService.preAuth(savedPayment.getId());
        Payment retrievedPayment = paymentRepository.getOne(savedPayment.getId());
        System.out.println(retrievedPayment.getState());
        //Assertions.assertEquals("PRE_AUTH", savedPayment.getState().toString());
    }
}