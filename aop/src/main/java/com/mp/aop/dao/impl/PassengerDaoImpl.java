package com.mp.aop.dao.impl;

import com.mp.aop.dao.PassengerDao;
import com.mp.aop.model.Passenger;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PassengerDaoImpl implements PassengerDao {

    private static Map<String, Passenger> passengersMap = new HashMap<>();

    public Passenger getPassenger(String id) {
        if (null != passengersMap.get(id)) {
            return passengersMap.get(id);
        }

        Passenger passenger = new Passenger(id);
        passengersMap.put(id, passenger);
        return passenger;
    }

}
