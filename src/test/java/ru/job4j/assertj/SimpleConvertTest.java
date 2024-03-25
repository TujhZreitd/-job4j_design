package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArrayFirst() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkArraySecond() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("", "three", "second", "");
        assertThat(array).filteredOn(e -> e.length() > 0)
                .hasSize(2)
                .contains("second")
                .contains("three", Index.atIndex(0))
                .containsAnyOf("zero", "first", "six", "", "second")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkListFirst() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("three", "second", "five", "first", "eleven");
        assertThat(list).allSatisfy(e -> {
            assertThat(e.length()).isLessThan(10);
            assertThat(e.length()).isGreaterThan(3);
        })
                .hasSize(5)
                .containsOnly("second", "eleven", "three", "five", "first")
                .startsWith("three", "second")
                .containsAnyOf("zero", "first", "six", "");
    }

    @Test
    void checkListSecond() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("one", "second", "", "four");
        assertThat(list).containsSequence("one", "second")
                .hasSize(4)
                .filteredOn(e -> e.contains("one"))
                .containsOnly("one");
    }

    @Test
    void checkSetFirst() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("one", "second", "three", "four");
        assertThat(set)
                .filteredOnAssertions(e -> assertThat(e.length()).isGreaterThan(4))
                .containsExactlyInAnyOrder("three", "second")
                .doesNotContain("one", "four")
                .allMatch(e -> e.length() > 4)
                .anySatisfy(e -> assertThat(e.length()).isGreaterThan(5));
    }

    @Test
    void checkSetSecond() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("one", "second", "three", "four", "one", "second");
        assertThat(set)
                .hasSize(4)
                .allMatch(e -> e.length() > 2)
                .anyMatch(e -> e.length() > 5)
                .noneMatch(e -> e.contains("eleven"));
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("one", "second", "three", "four");
        assertThat(map).containsKeys("one", "second")
                .containsValues(3, 0, 1)
                .containsEntry("one", 0);
    }
}