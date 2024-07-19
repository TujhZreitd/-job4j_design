package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    public static String makeAnswer(int number) {
        String result;
        if (number % 3 == 0 && number % 5 == 0) {
            result = "FizzBuzz";
        } else if (number % 3 == 0) {
            result = "Fizz";
        } else if (number % 5 == 0) {
            result = "Buzz";
        } else {
            result = String.valueOf(number);
        }
        return result;
    }

    public static boolean checkAnswer(String answer, int number) {
        boolean result = false;
        if (!makeAnswer(number).equals(answer)) {
            System.out.println("Ошибка. Начинай снова.");
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(makeAnswer(startAt));
            startAt++;
            if (checkAnswer(input.nextLine(), startAt)) {
                startAt = 0;
            }
            startAt++;
        }
    }
}