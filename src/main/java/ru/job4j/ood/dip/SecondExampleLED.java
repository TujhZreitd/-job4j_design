package ru.job4j.ood.dip;

public class SecondExampleLED {

    void ligthLED() {
        System.out.println("LED ON");
    }
}

class TV {
    SecondExampleLED led = new SecondExampleLED();
}
