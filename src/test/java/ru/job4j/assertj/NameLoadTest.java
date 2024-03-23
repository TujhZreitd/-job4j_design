package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkEmptyName() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("array is empty");
    }

    @Test
    void checkNameContainsKey() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("=As"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("contain a key");
    }

    @Test
    void checkNameContainsSymbol() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("Egor"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("contain the symbol");
    }

    @Test
    void checkNameContainsValue() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("Egor="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("contain a value");
    }
}