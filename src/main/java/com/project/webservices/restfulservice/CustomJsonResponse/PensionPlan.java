package com.project.webservices.restfulservice.CustomJsonResponse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

public class PensionPlan {

    @JsonView(View.ViewForPensionPlan.class)
    private String field1;

//    @JsonIgnore
    @JsonView({View.ViewForPensionPlan.class,View.ViewForPensionPlanList.class})
    private String field2;

    @JsonView(View.ViewForPensionPlanList.class)
    private String field3;

    public PensionPlan(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return "PensionPlan{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
