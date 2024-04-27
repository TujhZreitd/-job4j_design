package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/with_comment_and_empty_str.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Java")).isNull();
        assertThat(config.value("")).isNull();
    }

    @Test
    void whenPairWithDisruptionPatternFirst() {
        String path = "./data/disruption_pattern1.properties";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Config(path).load();
                });
        assertThat(exception.getMessage()).isEqualTo(new IllegalArgumentException().getMessage());
    }

    @Test
    void whenPairWithDisruptionPatternSecond() {
        String path = "./data/disruption_pattern2.properties";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Config(path).load();
                });
        assertThat(exception.getMessage()).isEqualTo(new IllegalArgumentException().getMessage());
    }

    @Test
    void whenPairWithDisruptionPatternThird() {
        String path = "./data/disruption_pattern3.properties";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Config(path).load();
                });
        assertThat(exception.getMessage()).isEqualTo(new IllegalArgumentException().getMessage());
    }

    @Test
    void whenPairWithDisruptionPatternFour() {
        String path = "./data/disruption_pattern4.properties";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Config(path).load();
                });
        assertThat(exception.getMessage()).isEqualTo(new IllegalArgumentException().getMessage());
    }

    @Test
    void whenPairWithTwoEquals() {
        String path = "./data/withTwoEquals.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Egor=");
        assertThat(config.value("surname")).isEqualTo("Yakushev=1");
    }
}