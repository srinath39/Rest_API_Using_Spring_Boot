package com.project.webservices.restfulservice.versioning.SpringBoot;

import com.project.webservices.restfulservice.versioning.Name;
import com.project.webservices.restfulservice.versioning.Person1;
import com.project.webservices.restfulservice.versioning.Person2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionRestControllerSB {

    @GetMapping(path="/{version}/person",version="1.0.0")
    public Person1 getFirstPersonPathParameter(){
        return new Person1("Bala Shiva");
    }

    @GetMapping(path="/{version}/person",version="2.0.0")
    public Person2 getSecondPersonPathParameter(){
        return new Person2(new Name("Bala","Shiva"));
    }
}
