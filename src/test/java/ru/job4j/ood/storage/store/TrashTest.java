package ru.job4j.ood.storage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.storage.food.Bread;
import ru.job4j.ood.storage.food.Food;
import ru.job4j.ood.storage.food.Meat;
import ru.job4j.ood.storage.food.Milk;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class TrashTest {
    @Test
    void whenAddNecessaryProducts() {
        Store store = new Trash();
        Food meat = new Meat(
                "Meat",
                LocalDate.of(2024, 7, 26),
                LocalDate.of(2024, 7, 1),
                1000.0);
        store.add(meat);
        assertThat(meat).isEqualTo(store.findByName("Meat"));
    }

    @Test
    void whenAddNotNecessaryProducts() {
        Store store = new Trash();
        Food blackBread = new Bread(
                "blackBread",
                LocalDate.of(2024, 7, 30),
                LocalDate.of(2024, 7, 26),
                100.0);
        Food whiteBread = new Bread(
                "whiteBread",
                LocalDate.of(2024, 7, 29),
                LocalDate.of(2024, 7, 25),
                100.0);
        store.add(blackBread);
        store.add(whiteBread);
        assertThat(store.findByName("blackBread")).isNull();
        assertThat(store.findByName("whiteBread")).isNull();
    }

}