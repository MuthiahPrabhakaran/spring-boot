package com.mp.springboot.jedis.dao;

public interface ProgrammerRepository {

    void setProgrammer(String id, String programmer);

    String getProgrammer(String id);
}
