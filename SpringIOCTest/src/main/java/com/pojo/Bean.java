package com.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bean {

    private String name;

    private String className;

    private String scope = "singleton";

    private List<Property> propertyList = new ArrayList<>();
}
