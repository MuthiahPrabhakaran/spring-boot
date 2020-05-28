package com.mp.springboot.jedis.service;

import com.mp.springboot.jedis.model.Programmer;

import java.util.List;
import java.util.Set;

public interface ProgrammerService {

    void setProgrammer(String id, String programmer);

    String getProgrammer(String id);

    void addToProgrammerList(Programmer programmer);

    List<Programmer> getProgrammers();

    Long getProgrammersListCount();

    void addToProgrammerSet(Programmer... programmer);

    Set<Programmer> getProgrammersSet();

    boolean isSetMember(Programmer programmer);
}
