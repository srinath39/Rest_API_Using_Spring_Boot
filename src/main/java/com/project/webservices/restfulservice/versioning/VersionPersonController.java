package com.project.webservices.restfulservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {

    // http://localhost:8080/version2/person

    @GetMapping("/version1/person")
    public Person1 getFirstVersionPersonPathParameter(){
        return new Person1("Srinath Mangali");
    }

    @GetMapping("/version2/person")
    public Person2 getSecondVersionPersonPathParameter(){
        return new Person2(new Name("Srinath","Mangali"));
    }

}
