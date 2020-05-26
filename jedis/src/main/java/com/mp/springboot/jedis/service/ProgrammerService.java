package com.mp.springboot.jedis.service;

public interface ProgrammerService {

    void setProgrammer(String id, String programmer);

    String getProgrammer(String id);
}
