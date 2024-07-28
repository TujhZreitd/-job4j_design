package ru.job4j.ood.storage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.storage.food.Bread;
import ru.job4j.ood.storage.food.Food;
import ru.job4j.ood.storage.food.Milk;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {
    @Test
    void whenAddNecessaryProducts() {
        Store store = new Warehouse();
        Food milk1 = new Milk(
                "Milk 3.2%",
                LocalDate.of(2024, 7, 31),
                LocalDate.of(2024, 7, 28),
                250.0);
        Food milk2 = new Milk(
                "Milk 1.0%",
                LocalDate.of(2024, 7, 31),
                LocalDate.of(2024, 7, 28),
                300.0);
        store.add(milk1);
        store.add(milk2);
        assertThat(milk1).isEqualTo(store.findByName("Milk 3.2%"));
        assertThat(milk2).isEqualTo(store.findByName("Milk 1.0%"));
    }

    @Test
    void whenAddNotNecessaryProducts() {
        Store store = new Warehouse();
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