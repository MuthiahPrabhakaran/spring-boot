package com.mp.springboot.jedis.dao;

import com.mp.springboot.jedis.model.Programmer;

import java.util.List;

public interface ProgrammerRepository {

    void setProgrammer(String id, String programmer);

    String getProgrammer(String id);

    void addToProgrammerList(Programmer programmer);

    List<Programmer> getProgrammers();

    Long getProgrammersListCount();
}
