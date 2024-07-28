package ru.job4j.ood.storage.food;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Food {
    private String name;
    private LocalDate expiryDate;
    private LocalDate createDate;
    private double price;
    private double discount;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        this.price = price - price * discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(name, food.name)
                && Objects.equals(expiryDate, food.expiryDate)
                && Objects.equals(createDate, food.createDate)
                && price == food.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expiryDate, createDate, price);
    }

    @Override
    public String toString() {
        return "Food {"
                + "name = " + name
                + ", expiryDate = " + expiryDate
                + ", createDate = " + createDate
                + ", price = " + price
                + ", discount = " + discount
                + '}';
    }
}
