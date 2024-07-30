package ru.job4j.ood.storage.store;

import ru.job4j.ood.storage.food.Food;

public class Trash extends AbstractStore {
    private static final double INDEX_ADD = 1;

    @Override
    public boolean add(Food food, String dateToday) {
        boolean result = false;
        if (indexStore(food, dateToday) >= INDEX_ADD) {
            store.add(food);
            result = true;
        }
        return result;
    }
}
/*для повторного коммита*/