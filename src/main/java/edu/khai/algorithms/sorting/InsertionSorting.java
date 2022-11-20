package edu.khai.algorithms.sorting;

public class InsertionSorting implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            int j = i;
            while (j > 0 && cur < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = cur;
        }
    }
}
