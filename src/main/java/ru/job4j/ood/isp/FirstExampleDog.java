package ru.job4j.ood.isp;

interface AnimalAction {
    void eat();

    void run();

    void fly();
}

public class FirstExampleDog implements AnimalAction  {
    @Override
    public void eat() {
        System.out.println("Dog eat");
    }

    @Override
    public void run() {
        System.out.println("Dog run");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }
}



