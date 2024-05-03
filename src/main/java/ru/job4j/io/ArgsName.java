package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        for (String str : args) {
            if (!str.contains("=")) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain an equal sign", str));
            }
            String[] s = str.split("=", 2);
            if (s[0].charAt(0) != '-') {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not start with a '-' character", str));
            }
            s[0] = s[0].replace("-", "");
            s[1] = s[1].replace("-", "");
            if ((s[0]).isEmpty()) {
                throw new IllegalArgumentException(
                        String.format("Error: This argument '%s' does not contain a key", str));
            }
            if ((s[1]).isEmpty()) {
                throw new IllegalArgumentException(
                        String.format("Error: This argument '%s' does not contain a value", str));
            }
            values.put(s[0], s[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
