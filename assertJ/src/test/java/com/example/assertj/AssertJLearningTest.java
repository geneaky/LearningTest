package com.example.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJLearningTest {

    @Test
    public void assertJEqualsTest() throws Exception
    {
        //given
        assertThat("string").isEqualTo("string");
        //when

        //then
    }
}
