package com.mp.springboot.jedis.service;

import com.mp.springboot.jedis.dao.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

    @Autowired
    ProgrammerRepository programmerRepository;

    public void setProgrammer(String id, String programmer){
        programmerRepository.setProgrammer(id, programmer);
    }

    public String getProgrammer(String id){
       return programmerRepository.getProgrammer(id);
    }
}
