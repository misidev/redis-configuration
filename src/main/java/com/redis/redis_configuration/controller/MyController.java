package com.redis.redis_configuration.controller;

import com.redis.redis_configuration.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/data/{id}")
    public String getData(@PathVariable String id) {
        return myService.getData(id);
    }

}
