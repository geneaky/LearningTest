package com.example.assertj;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJLearningTest {

    @Test
    @DisplayName("동등 비교 메서드 체이닝")
    public void assertJEqualsTest() throws Exception
    {
        assertThat("string").isEqualTo("string");
    }

    @Test
    @DisplayName("요소 포함 여부, 동등 비교")
    public void split() throws Exception
    {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1","2");

        values = "1".split(",");
        assertThat(values).containsExactly("1");
    }

    @Test
    @DisplayName("as()사용 실패 메시지 출력")
    public void failMessage() throws Exception
    {
        //given
        int age = 5;
        String name = "HiBs";
        //then
        assertThat(5).as("check %s's age",name).isEqualTo(4);
    }

    @Test
    public void test1() throws Exception
    {
        //given
        String sample = "HiBs";
        Pattern pattern = Pattern.compile("[a-z]");
        //when

        //then
        assertThat(sample).hasSize(4)
                .containsPattern(pattern)
                .doesNotEndWith("a")
                .isNotEqualTo("hibs");
    }

    @Test
    public void test2() throws Exception
    {
        //given
        Map<String,Float> map = new HashMap<>();
        map.put("x",24.3F);
        map.put("y",126.45F);
        Home home = new Home("sweetHome","151-23",map);
        Student student = Student.builder()
                .age(10)
                .name("HiBs")
                .lessons(new ArrayList<>(Arrays.asList("math","english","art","science")))
                .home(home)
                .role(Role.HIGH)
                .build();
        Map<String,Float> map2 = new HashMap<>();
        map2.put("x",24.3F);
        map2.put("y",126.45F);
        Home home2 = new Home("sweetHome","151-23",map2);
        Student student2 = Student.builder()
                .age(10)
                .name("HiBs")
                .lessons(new ArrayList<>(Arrays.asList("math","english","art","science")))
                .home(home2)
                .role(Role.HIGH)
                .build();
        //then
        assertThat(student)
                .isNotNull()
                .isExactlyInstanceOf(Student.class)
                .usingRecursiveComparison()
                .isEqualTo(student2);

        assertThat(student)
                .extracting("lessons")
                .isEqualTo(new ArrayList<>(Arrays.asList("math","english","art","science")));

        Assertions.assertThatThrownBy(()->{throw new Exception("boom!");})
                .isInstanceOf(Exception.class)
                .hasMessage("boom!");
    }
}
