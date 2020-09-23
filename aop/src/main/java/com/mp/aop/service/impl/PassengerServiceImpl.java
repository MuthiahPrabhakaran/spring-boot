package com.mp.aop.service.impl;

import com.mp.aop.dao.PassengerDao;
import com.mp.aop.model.Passenger;
import com.mp.aop.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerDao passengerDao;

    @Override
    public Passenger getPassenger(String id) {
        return passengerDao.getPassenger(id);
    }
}
