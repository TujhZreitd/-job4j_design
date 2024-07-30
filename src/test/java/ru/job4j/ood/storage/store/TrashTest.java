package ru.job4j.ood.storage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.storage.food.Bread;
import ru.job4j.ood.storage.food.Food;
import ru.job4j.ood.storage.food.Meat;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class TrashTest {
    @Test
    void whenAddNecessaryProducts() {
        Store store = new Trash();
        String dateToday = "2024-07-27";
        Food meat = new Meat(
                "Meat",
                LocalDate.of(2024, 7, 26),
                LocalDate.of(2024, 7, 1),
                1000.0);
        store.add(meat, dateToday);
        assertThat(meat).isEqualTo(store.findByName("Meat"));
    }

    @Test
    void whenAddNotNecessaryProducts() {
        Store store = new Trash();
        String dateToday = "2024-07-27";
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
        store.add(blackBread, dateToday);
        store.add(whiteBread, dateToday);
        assertThat(store.findByName("blackBread")).isNull();
        assertThat(store.findByName("whiteBread")).isNull();
    }

}
