package edu.khai.algorithms.sorting;

public class SelectionSorting implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[min]) min = j;
            int dummy = array[i];
            array[i] = array[min];
            array[min] = dummy;
        }
    }
}
