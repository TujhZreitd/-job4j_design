package ru.job4j.ood.lsp;

public class SecondExampleEmployee {
    SecondExampleEmployee get() {
        return new SecondExampleEmployee();
    }
}

class Doctor extends SecondExampleEmployee {
    void init() {

    }

    Doctor get() {
        init();
        return new Doctor();
    }
}
