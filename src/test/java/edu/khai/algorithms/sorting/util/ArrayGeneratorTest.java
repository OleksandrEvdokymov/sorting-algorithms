package edu.khai.algorithms.sorting.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayGeneratorTest {

    private ArrayGenerator arrayGenerator;

    @BeforeEach
    void setUp(){
        arrayGenerator = new ArrayGenerator();
    }

    @Test
    void testGenerateEmptyArray() {
        int n = 0;
        assertArrayEquals(new int[0], arrayGenerator.generate(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2330, 5900, 8315, 12120, 39600, 70700})
    void testGenerate(int n) {
        int[] generatedArray = arrayGenerator.generate(n);
        assertEquals(n, generatedArray.length);
        Arrays.stream(generatedArray).forEach(element -> 
                assertTrue(element > 0));
    }
}