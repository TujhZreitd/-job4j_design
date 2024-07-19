package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void makeAnswerWhen1() {
        assertThat(Fool.makeAnswer(1)).isEqualTo(String.valueOf(1));
    }

    @Test
    void makeAnswerWhen2() {
        assertThat(Fool.makeAnswer(2)).isEqualTo(String.valueOf(2));
    }

    @Test
    void makeAnswerWhen3() {
        assertThat(Fool.makeAnswer(3)).isEqualTo("Fizz");
    }

    @Test
    void makeAnswerWhen5() {
        assertThat(Fool.makeAnswer(5)).isEqualTo("Buzz");
    }

    @Test
    void makeAnswerWhen15() {
        assertThat(Fool.makeAnswer(15)).isEqualTo("FizzBuzz");
    }
}