package com.mp.spring.statemachine.config;

import com.mp.spring.statemachine.domain.PaymentEvent;
import com.mp.spring.statemachine.domain.PaymentState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StateMachineConfigTest {

    @Autowired
    StateMachineFactory<PaymentState, PaymentEvent> stateMachineFactory;

    @Test
    void testNewStateMachine() {
        StateMachine<PaymentState, PaymentEvent> stateMachine = stateMachineFactory.getStateMachine();
        stateMachine.start();
        System.out.println(stateMachine.getState().toString());
        stateMachine.sendEvent(PaymentEvent.PRE_AUTHORIZE);
        System.out.println(stateMachine.getState().toString());
        stateMachine.sendEvent(PaymentEvent.PRE_AUTHORIZE);
        System.out.println(stateMachine.getState().toString());
    }
}