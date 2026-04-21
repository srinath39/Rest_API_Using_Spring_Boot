package com.project.webservices.restfulservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping(path ="/hello-world")
    public String helloWorld(){
        return "Hello-World";
    }

    @GetMapping(path ="/hello-world-bean")
    public HelloWorld helloWorldBean(){
        return new HelloWorld("This is Hello World Bean");
    }

    @GetMapping(path ="/hello-world/path-variable/{name}")
    public HelloWorld helloWorldPathVariable(@PathVariable String name){
        return new HelloWorld(String.format("Hello world , %s",name));
    }

}
