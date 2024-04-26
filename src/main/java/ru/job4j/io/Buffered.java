package ru.job4j.io;

import java.io.*;

public class Buffered {
    public static void main(String[] args) {
        try (BufferedReader bufInput = new BufferedReader(new FileReader("data/input.txt"));
             BufferedWriter bufOutput = new BufferedWriter(new FileWriter("data/output.txt"))) {
            String rsl;
            while ((rsl = bufInput.readLine()) != null) {
                bufOutput.write(rsl);
                bufOutput.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
