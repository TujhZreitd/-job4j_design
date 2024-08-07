package ru.job4j.algo.twopointer;

import java.util.Arrays;

public class SmallestRangeFinder {
    public static int[] findSmallestRange(int[] nums, int k) {
        int[] result = new int[2];
        int firstPointer = 0;
        int secondPointer = 1;
        int res = 1;
        int firstResult = 0;
        while (res < k && secondPointer < nums.length) {
            if (nums[firstPointer] == nums[secondPointer]) {
                firstResult = secondPointer;
                firstPointer++;
                secondPointer++;
                res = 1;
            } else {
                if (++res == k) {
                    result[0] = firstResult;
                    result[1] = secondPointer;
                }
                firstPointer++;
                secondPointer++;
            }
        }
        return result[1] != 0 ? result : null;
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Использовано памяти: " + (memoryAfter - memoryBefore) + " байт");
    }
}
