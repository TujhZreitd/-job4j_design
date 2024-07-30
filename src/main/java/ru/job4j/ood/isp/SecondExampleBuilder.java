package ru.job4j.ood.isp;

interface Employee {
    void getSalary();

    void eat();

    void getVacation();

    void build();

    void teach();
}

public class SecondExampleBuilder implements Employee {
    @Override
    public void getSalary() {
        System.out.println("Builder get salary");
    }

    @Override
    public void eat() {
        System.out.println("Builder eat");
    }

    @Override
    public void getVacation() {
        System.out.println("Builder get vacantion");
    }

    @Override
    public void build() {
        System.out.println("Builder build");
    }

    @Override
    public void teach() {
        throw new UnsupportedOperationException();
    }
}
