package com.project.webservices.restfulservice.CustomJsonResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filter-plan")
    public PensionPlan getFilterPensionPlan(){
        return new PensionPlan("value1","value2","value3");
    }

    @GetMapping("/filter-plan-list")
    public List<PensionPlan> getFilterPensionPlanList(){
        return Arrays.asList(new PensionPlan("value1","value2","value3"),
                new PensionPlan("value4","value5","value6"));
    }
}
