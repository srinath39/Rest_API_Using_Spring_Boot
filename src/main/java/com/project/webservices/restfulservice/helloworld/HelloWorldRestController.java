package com.project.webservices.restfulservice.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @RequestMapping(method= RequestMethod.GET,path ="/hello-world")
    public String helloWorld(){
        return "Hello-World";
    }
}
