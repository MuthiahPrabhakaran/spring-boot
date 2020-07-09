package com.mp.employee;

import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BasePathAwareController
public class ExampleService {

    @RequestMapping("/schedule")
    public String getSchedule() {

        return "Your v1 schedule is M-F 9-9";
    }

    @RequestMapping("/old-schedule")
    public String getOldSchedule() {

        return "Your v1 schedule is M-S 9-9";
    }
}
