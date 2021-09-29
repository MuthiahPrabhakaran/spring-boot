package com.mp.spring.statemachine.service;

import com.mp.spring.statemachine.domain.Payment;
import com.mp.spring.statemachine.domain.PaymentEvent;
import com.mp.spring.statemachine.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {

    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);
}
