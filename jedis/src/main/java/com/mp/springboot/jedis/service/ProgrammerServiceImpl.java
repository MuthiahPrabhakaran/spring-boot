package com.mp.springboot.jedis.service;

import com.mp.springboot.jedis.dao.ProgrammerRepository;
import com.mp.springboot.jedis.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    @Override
    public void addToProgrammerList(Programmer programmer) {
        programmerRepository.addToProgrammerList(programmer);
    }

    @Override
    public List<Programmer> getProgrammers() {
        return programmerRepository.getProgrammers();
    }

    @Override
    public Long getProgrammersListCount() {
        return programmerRepository.getProgrammersListCount();
    }

    @Override
    public void addToProgrammerSet(Programmer... programmer) {
        programmerRepository.addToProgrammerSet(programmer);
    }

    @Override
    public Set<Programmer> getProgrammersSet() {
        return programmerRepository.getProgrammersSet();
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return programmerRepository.isSetMember(programmer);
    }
}
