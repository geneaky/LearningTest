package com.example.assertj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Home {

    private String name;
    private String address;
    private Map<String,Float> location;
}
