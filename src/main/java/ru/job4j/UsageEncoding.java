package ru.job4j;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class UsageEncoding {
    public String readFile(String path) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path, Charset.forName("UTF-8")))) {
            reader.lines()
                    .map(string -> string + System.lineSeparator())
                    .forEach(result::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public void writeFile(String path, String string) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataFile(String path, List<String> data) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(path, Charset.forName("UTF-8"), true))) {
            data.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "./data/text.txt";
        UsageEncoding encoding = new UsageEncoding();
        List<String> strings = List.of(
                "Новая строка 1",
                "Новая строка 2",
                "Новая строка 3",
                "Новая строка 4",
                "Новая строка 5"
        );
        encoding.writeDataFile(path, strings);
        String string = encoding.readFile(path);
        System.out.println("Данные из файла: ");
        System.out.println(string);
    }
}
