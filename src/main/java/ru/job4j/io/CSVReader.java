package ru.job4j.io;

import java.io.*;
import java.util.*;

public class CSVReader {
       public static void handle(ArgsName argsName) {
           List<String> filterValue = new ArrayList<>(Arrays.asList(argsName.get("filter").split(",")));
           List<String> readString;
           StringBuilder resultString = new StringBuilder();
           int[] indexOut = new int[filterValue.size()];
           List<StringBuilder> result = new ArrayList<>();
           String delimiter = argsName.get("delimiter");
           try (Scanner scanner = new Scanner(new FileReader(argsName.get("path")))) {
               readString = new ArrayList<>(Arrays.asList(scanner.nextLine().split(delimiter)));
               for (int i = 0; i < filterValue.size(); i++) {
                    resultString.append(filterValue.get(i));
                   if (i < filterValue.size() - 1) {
                       resultString.append(delimiter);
                   }
                    indexOut[i] = readString.indexOf(filterValue.get(i));
               }
               result.add(resultString);
               resultString = new StringBuilder();
               while (scanner.hasNext()) {
                   readString = new ArrayList<>(Arrays.asList(scanner.nextLine().split(delimiter)));
                   for (int i = 0; i < indexOut.length; i++) {
                       resultString.append(readString.get(indexOut[i]));
                       if (i < indexOut.length - 1) {
                           resultString.append(delimiter);
                       }
                   }
                   result.add(resultString);
                   resultString = new StringBuilder();
               }
           } catch (IOException e) {
                e.printStackTrace();
           }
           if ("stdout".equals(argsName.get("out"))) {
                   for (StringBuilder sb : result) {
                       System.out.println(sb);
                   }
           } else {
               try (PrintWriter writer = new PrintWriter(new FileWriter(argsName.get("out")))) {
                   for (StringBuilder s : result) {
                       writer.println(s);
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Введено не верное количество аргументов");
        }
        ArgsName argsName = ArgsName.of(args);
        if (!argsName.get("path").contains(".csv")) {
            throw new IllegalArgumentException(String.format("Unacceptable value path %s", argsName.get("path")));
        }
        File file = new File(argsName.get("path"));
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        String out = argsName.get("out");
        if ((!"stdout".equals(out)) && (!out.contains(".csv"))) {
            throw new IllegalArgumentException(String.format("Unacceptable value out %s", out));
        }
        String[] filters = argsName.get("filter").split(",");
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            String first = scanner.nextLine();
            for (String filter : filters) {
                if (!first.contains(filter)) {
                    throw new IllegalArgumentException(String.format("Filter \"%s\" not contains in file", filter));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        handle(argsName);
    }
}
