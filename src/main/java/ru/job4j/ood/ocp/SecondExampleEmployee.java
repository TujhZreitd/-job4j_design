package ru.job4j.ood.ocp;

public class SecondExampleEmployee {
    public String work() {
        return "Employee work";
    }

    public String cure() {
        return "Employee cure";
    }
}

class Builder extends SecondExampleEmployee {
    public String work() {
        return "Builder work";
    }

    public String cure() {
        return "Builder not cure";
    }
}
