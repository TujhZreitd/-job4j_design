package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = input.read()) != -1) {
                text.append((char) read);
            }
            String[] numbers = text.toString().split(System.lineSeparator());
            for (String line : numbers) {
                System.out.println(Integer.parseInt(line) % 2 == 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
