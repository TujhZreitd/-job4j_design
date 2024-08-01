package ru.job4j.ood.storage;

import ru.job4j.ood.storage.food.Food;
import ru.job4j.ood.storage.store.Store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ControlQuality {

    private void addForStore(List<Food> foods, Store store, String dateToday) {
        Iterator<Food> foodsIterator = foods.iterator();
        while (foodsIterator.hasNext()) {
            Food food = foodsIterator.next();
            if (store.add(food, dateToday)) {
                foodsIterator.remove();
            }
        }
    }

    public void addForStores(List<Food> foods, List<Store> stores, String dateToday) {
        for (Store store : stores) {
            addForStore(foods, store, dateToday);
        }
    }

    private List<Food> extractionForStore(Store store) {
        List<Food> result = store.findAll();
        store.deleteAll();
        return result;
    }

    public void resortForStores(List<Store> stores, String dateToday) {
        List<Food> extractionFoods = new ArrayList<>();
        for (Store store : stores) {
            extractionFoods.addAll(extractionForStore(store));
        }
        addForStores(extractionFoods, stores, dateToday);
    }
}

