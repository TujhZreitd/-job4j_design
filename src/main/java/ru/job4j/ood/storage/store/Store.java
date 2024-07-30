package ru.job4j.ood.storage.store;

import ru.job4j.ood.storage.food.Food;

import java.util.List;

public interface Store {

    boolean add(Food food, String dateToday);

    boolean delete(Food food);

    List<Food> findAll();

    Food findByName(String name);

}
