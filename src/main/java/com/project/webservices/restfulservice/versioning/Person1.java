package com.project.webservices.restfulservice.versioning;

public class Person1 {

    private String name;

    public Person1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                '}';
    }
}
