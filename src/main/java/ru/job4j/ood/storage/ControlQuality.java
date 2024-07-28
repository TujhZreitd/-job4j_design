package ru.job4j.ood.storage;

import ru.job4j.ood.storage.food.Food;
import ru.job4j.ood.storage.store.Store;
import java.util.Iterator;
import java.util.List;

public class ControlQuality {

    private void addForStore(List<Food> foods, Store store) {
        Iterator<Food> foodsIterator = foods.iterator();
        while (foodsIterator.hasNext()) {
            Food food = foodsIterator.next();
            if (store.add(food)) {
                foodsIterator.remove();
            }
        }
    }

    public void addForStores(List<Food> foods, List<Store> stores) {
        for (Store store : stores) {
            addForStore(foods, store);
        }
    }
}
