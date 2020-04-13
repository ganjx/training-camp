package com.training.springboot.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String get(){

        return "hello";
    }
}
