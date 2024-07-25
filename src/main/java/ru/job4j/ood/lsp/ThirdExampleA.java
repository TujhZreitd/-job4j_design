package ru.job4j.ood.lsp;

public class ThirdExampleA {

    Integer sum(int a, int b) {
        return a + b;
    }
}

class B extends ThirdExampleA {
    Integer sum(int a, int b) {
        return null;
    }
}