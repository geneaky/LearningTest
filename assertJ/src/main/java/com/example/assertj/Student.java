package com.example.assertj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private String name;
    private int age;

    private List<String> lessons;
    private Role role;

    private Home home;

}
