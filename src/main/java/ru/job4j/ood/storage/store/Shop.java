package ru.job4j.ood.storage.store;

import ru.job4j.ood.storage.food.Food;

public class Shop extends AbstractStore {
    private static final double INDEX_ADD = 0.25;
    private static final double INDEX_ADD_WITH_DISCOUNT = 0.75;
    private static final double INDEX_NOT_ADD = 1;
    private static final double DISCOUNT = 0.2;

    @Override
    public boolean add(Food food, String dateToday) {
        boolean result = false;
        double index = indexStore(food, dateToday);
        if (index >= INDEX_ADD && index < INDEX_ADD_WITH_DISCOUNT) {
            store.add(food);
            result = true;
        }
        if (index >= INDEX_ADD_WITH_DISCOUNT && index < INDEX_NOT_ADD) {
            food.setDiscount(DISCOUNT);
            store.add(food);
            result = true;
        }
        return result;
    }
}
