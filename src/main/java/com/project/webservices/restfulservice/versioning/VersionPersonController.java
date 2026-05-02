package com.project.webservices.restfulservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {

    // http://localhost:8080/version1/person
    @GetMapping("/version1/person")
    public Person1 getFirstVersionPersonPathParameter(){
        return new Person1("Srinath Mangali");
    }

    // http://localhost:8080/version2/person
    @GetMapping("/version2/person")
    public Person2 getSecondVersionPersonPathParameter(){
        return new Person2(new Name("Srinath","Mangali"));
    }

    // http://localhost:8080/person?version=1
    @GetMapping(path="/person",params ="version=1")
    public Person1 getFirstVersionPersonQueryParameter(){
        return new Person1("Srinath Mangali");
    }

    // http://localhost:8080/person?version=1
    @GetMapping(path="/person",params ="version=2")
    public Person2 getSecondVersionPersonQueryParameter(){
        return new Person2(new Name("Srinath","Mangali"));
    }

}
