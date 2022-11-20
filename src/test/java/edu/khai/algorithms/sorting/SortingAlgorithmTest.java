package edu.khai.algorithms.sorting;

import edu.khai.algorithms.sorting.util.ArrayGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SortingAlgorithmTest {

    private ArrayGenerator arrayGenerator;

    private SortingAlgorithm sortingAlgorithm;
    @BeforeEach
    void setUp() {
        arrayGenerator = new ArrayGenerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2330, 5900, 8315, 12120, 39600, 70700})
    void testBubbleSort(int n){
        sortingAlgorithm = new BubbleSorting();
        int[] array = arrayGenerator.generate(n);
        sortingAlgorithm.sort(array);
        for(int i = 0; i < n-1 ; i++){
            assertTrue(array[i] >= array[i+1]);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2330, 5900, 8315, 12120, 39600, 70700})
    void testSelectionSort(int n){
        sortingAlgorithm = new SelectionSorting();
        int[] array = arrayGenerator.generate(n);
        sortingAlgorithm.sort(array);
        for(int i = 0; i < n-1 ; i++){
            assertTrue(array[i] <= array[i+1]);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2330, 5900, 8315, 12120, 39600, 70700})
    void testInsertionSort(int n){
        sortingAlgorithm = new InsertionSorting();
        int[] array = arrayGenerator.generate(n);
        sortingAlgorithm.sort(array);
        for(int i = 0; i < n-1 ; i++){
            assertTrue(array[i] <= array[i+1]);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2330, 5900, 8315, 12120, 39600, 70700})
    void testQuickSort(int n){
        sortingAlgorithm = new QuickSorting();
        int[] array = arrayGenerator.generate(n);
        sortingAlgorithm.sort(array);
        for(int i = 0; i < n-1 ; i++){
            assertTrue(array[i] <= array[i+1]);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2330, 5900, 8315, 12120, 39600, 70700})
    void testShellSort(int n){
        sortingAlgorithm = new ShellSorting();
        int[] array = arrayGenerator.generate(n);
        sortingAlgorithm.sort(array);
        for(int i = 0; i < n-1 ; i++){
            assertTrue(array[i] <= array[i+1]);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2330, 5900, 8315, 12120, 39600, 70700})
    void testHeapSort(int n){
        sortingAlgorithm = new HeapSorting();
        int[] array = arrayGenerator.generate(n);
        sortingAlgorithm.sort(array);
        for(int i = 0; i < n-1 ; i++){
            assertTrue(array[i] <= array[i+1]);
        }
    }
}