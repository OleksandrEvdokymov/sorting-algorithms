package edu.khai.algorithms.sorting.util;

import java.util.Random;

public class ArrayGenerator {

    private final Random random;
    public ArrayGenerator(){
        random = new Random();
    }
    public int[] generate(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = getRandomNumber(n);
        }
        return array;
    }

    private int getRandomNumber(int max) {
        return random.nextInt(max - 1) + 1;
    }
}
