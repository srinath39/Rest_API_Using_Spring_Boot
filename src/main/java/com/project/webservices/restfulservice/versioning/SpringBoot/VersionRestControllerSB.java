package com.project.webservices.restfulservice.versioning.SpringBoot;

import com.project.webservices.restfulservice.versioning.Name;
import com.project.webservices.restfulservice.versioning.Person1;
import com.project.webservices.restfulservice.versioning.Person2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionRestControllerSB {
//   // http://localhost:8080/1.O.O/person
//    @GetMapping(path="/{version}/person",version="1.0.0")
//    public Person1 getFirstPersonPathParameter(){
//        return new Person1("Bala Shiva");
//    }

//    // http://localhost:8080/2.O.O/person
//    @GetMapping(path="/{version}/person",version="2.0.0")
//    public Person2 getSecondPersonPathParameter(){
//        return new Person2(new Name("Bala","Shiva"));
//    }

    // http://localhost:8080/person?version=1   , String version need to match with the query parameter in Configuration
    // http://localhost:8080/person  (custom header:  GET-PERSON-API-VERSION=2)
    // http://localhost:8080/person  (media type header:  accept=application/json;version=1)
    @GetMapping(path="/person",version="1.0.0")
    public Person1 getFirstPersonPathParameter(){
        return new Person1("Bala Shiva");
    }

    @GetMapping(path="/person",version="2.0.0")
    public Person2 getSecondPersonPathParameter(){
        return new Person2(new Name("Bala","Shiva"));
    }
}
