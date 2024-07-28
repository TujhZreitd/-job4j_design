package ru.job4j.ood.storage.food;

import java.time.LocalDate;

public class Bread extends Food {
    public Bread(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        super(name, expiryDate, createDate, price);
    }
}
