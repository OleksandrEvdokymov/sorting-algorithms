package edu.khai.algorithms.sorting;

public class ShellSorting implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        int size = array.length;
        for (int s = size / 2; s > 0; s /= 2) {
            for (int i = s; i < size; ++i) {
                for (int j = i - s; j >= 0 && array[j] > array[j + s]; j -= s) {
                    int temp = array[j];
                    array[j] = array[j + s];
                    array[j + s] = temp;
                }
            }
        }
    }
}
