package com.mp.springboot.jedis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mp.springboot.jedis.model.Programmer;
import com.mp.springboot.jedis.service.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/programmer")
public class ProgrammerController {

    @Autowired
    ProgrammerService programmerService;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.POST)
    public void addTopic(@RequestBody Programmer programmer) throws JsonProcessingException {
        programmerService.setProgrammer(String.valueOf(programmer.getId()), objectMapper.writeValueAsString(programmer));
    }

    //@GetMapping(value ={"","/"})
    @RequestMapping("/{id}")
    public String getValue(@PathVariable String id){
        return programmerService.getProgrammer(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addToList")
    public void addToList(@RequestBody Programmer programmer){
        programmerService.addToProgrammerList(programmer);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getProgrammers")
    public List<Programmer> getProgrammers(){
        return programmerService.getProgrammers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getProgrammersCount")
    public Long getProgrammersCount(){
        return programmerService.getProgrammersListCount();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/programmer-set")
    public void addToSet(@RequestBody Programmer... programmer){
        programmerService.addToProgrammerSet(programmer);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/programmer-set")
    public Set<Programmer> getProgrammersSet(){
        return programmerService.getProgrammersSet();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/programmer-set/member")
    public boolean isSetMember(@RequestBody Programmer programmer){
        return programmerService.isSetMember(programmer);
    }

}
