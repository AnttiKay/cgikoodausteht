package com.koodausTehtävät.tehtävä2;

import java.security.InvalidParameterException;

public class NumberLength {
    // Returns the smallest number of natural numbers 0,1,2,3... between array elements.
    // [1, 4, 10] returns 2 as there are two numbers: 2, 3 between 1, 4.
    // [4, 1, 10] returns 2 as there are two numbers: 2, 3 between 4, 1.
    // [5, 5] returns 0 as there are no natural numbers between 5, 5.
    // Throws InvalidParameterException if array has non natural numbers, such as -1, -2, -3;
    // Returns -1 if array is empty or null or the array has length of 1. 
    public static int getSmallestNaturalNumber(int[] array) {
        if(array == null || array.length < 2 ){
            return -1;
        }
        int smallest = Integer.MAX_VALUE;
        int result;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++){
                if (array[j] < 0) {
                    throw new InvalidParameterException();
                }
                // Math.abs is used here so that we get the distance to the other number
                result = Math.abs(array[i] - array[j]) - 1;

                if (result > 0 && result < smallest) {
                    smallest = result;
                }
            }
        }
        if (smallest == Integer.MAX_VALUE) {
            smallest = 0;
        }
        return smallest;
    }
}
