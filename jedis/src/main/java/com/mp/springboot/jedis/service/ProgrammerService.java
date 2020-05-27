package com.mp.springboot.jedis.service;

import com.mp.springboot.jedis.model.Programmer;

import java.util.List;

public interface ProgrammerService {

    void setProgrammer(String id, String programmer);

    String getProgrammer(String id);

    void addToProgrammerList(Programmer programmer);

    List<Programmer> getProgrammers();

    Long getProgrammersListCount();
}
