package com.project.webservices.restfulservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldRestController {

    private MessageSource messageSource;

    @Autowired
    public HelloWorldRestController(MessageSource messageSource){
        this.messageSource=messageSource;
    }

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

    @GetMapping(path ="/hello-world-internalization")
    public String helloWorldInternalization(){
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("GOOD_MORNING_MESSAGE_KEY",null,"Default text",locale);
    }

}
