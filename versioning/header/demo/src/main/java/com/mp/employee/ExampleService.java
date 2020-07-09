package com.mp.employee;

import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BasePathAwareController
public class ExampleService {

    @RequestMapping(value = "/schedule", headers = "Accept-version=v1")
    public String getScheduleV1() {

        return "Your v2 schedule is M-W 6-6";
    }

    @RequestMapping(value = "/schedule", headers = "Accept-version=v2")
    public String getScheduleV2() {

        return "Your v2 schedule is M-S 6-6";
    }
}
