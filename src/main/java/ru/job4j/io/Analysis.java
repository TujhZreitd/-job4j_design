package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {

        try (BufferedReader input = new BufferedReader(new FileReader(source));
            BufferedWriter output = new BufferedWriter(new FileWriter(target))) {
            String rsl;
            boolean flag = false;
            while ((rsl = input.readLine()) != null) {
                String[] str = rsl.split(" ");
                if (("400".equals(str[0]) || "500".equals(str[0])) != flag) {
                    flag = !flag;
                    output.write(str[1]);
                    output.write(';');
                    if (!flag) {
                        output.write("\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
