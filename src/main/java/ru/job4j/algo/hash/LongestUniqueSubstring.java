package ru.job4j.algo.hash;

import java.util.*;

public class LongestUniqueSubstring {

    private static StringBuilder characterToStringBuilder(Set<Character> chars) {
        StringBuilder result = new StringBuilder();
        for (Character ch : chars) {
            result.append(ch);
        }
        return result;
    }

    private static void putSubString(Set<Character> chars, Map<Integer, StringBuilder> map) {
        StringBuilder subString = characterToStringBuilder(chars);
        map.put(subString.length(), subString);
    }

    public static String longestUniqueSubstring(String str) {
        if (str.isEmpty()) {
            return str;
        }
        Set<Character> result = new HashSet<>();
        Map<Integer, StringBuilder> substrings = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (result.contains(str.charAt(i))) {
                putSubString(result, substrings);
                result.clear();
            }
            if (!result.contains(str.charAt(i))) {
                result.add(str.charAt(i));
            }
            if (i == str.length() - 1) {
                putSubString(result, substrings);
            }
        }
        Set<Integer> lengths = substrings.keySet();
        Integer maxLength = Collections.max(lengths);
        return substrings.get(maxLength).toString();
    }

    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        long memoryBefore = run.totalMemory() - run.freeMemory();
        String str = "acabcer";
        String result = longestUniqueSubstring(str);
        long memoryAfter = run.totalMemory() - run.freeMemory();
        System.out.println("Использовано памяти: " + (memoryAfter - memoryBefore) + " байт");
        System.out.println(result);
        System.out.println("New change");

    }
}
