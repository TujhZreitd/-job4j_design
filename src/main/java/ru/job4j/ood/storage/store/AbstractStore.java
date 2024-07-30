package ru.job4j.ood.storage.store;

import ru.job4j.ood.storage.food.Food;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected final List<Food> store = new ArrayList<>();

    public double indexStore(Food food, String dateToday) {
        LocalDate createDate = food.getCreateDate();
        LocalDate expiryDate = food.getExpiryDate();
        LocalDate todayDate = LocalDate.parse(dateToday);
        double countDayLife = Period.between(createDate, expiryDate).getDays();
        double countDayFromCreate = Period.between(createDate, todayDate).getDays();
        return countDayFromCreate / countDayLife;
    }

    @Override
    public boolean delete(Food food) {
        return store.remove(food);
    }

    @Override
    public List<Food> findAll() {
        return List.copyOf(store);
    }

    @Override
    public Food findByName(String name) {
        Food res = null;
        for (Food food : store) {
            if (food.getName().equals(name)) {
                res = food;
            }
        }
        return res;
    }
}
