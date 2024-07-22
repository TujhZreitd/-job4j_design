package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
@Disabled("Тесты отключены.")
class GeneratorWordsTest {
    @Test
    public void whenGeneratorContainsKeys() {
        Generator generator = new GeneratorWords();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("subject", "you");
        String result = "I am a Petr Arsentev, Who are you?";
        assertThat(result).isEqualTo(generator.produce("I am a ${name}, Who are ${subject}?", map));
    }

    @Test
    public void whenGeneratorNotContainsKeys() {
        Generator generator = new GeneratorWords();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        assertThatThrownBy(() -> generator.produce("I am a ${name} ${surname}", map))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenGeneratorContainsMoreKeys() {
        Generator generator = new GeneratorWords();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        map.put("surname", "Ivanov");
        map.put("age", "20");
        assertThatThrownBy(() -> generator.produce("I am a ${name} ${surname}", map))
                .isInstanceOf(IllegalArgumentException.class);
    }
}