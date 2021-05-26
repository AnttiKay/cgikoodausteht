package com.koodausTehtävät.tehtävä2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

public class NumberLengthTest {
    @Test
    public void testGetLengthBetweenNumbers() {
        int[] array = { 1, 4, 10 };
        assertEquals(2, NumberLength.getSmallestNaturalNumber(array));

        int[] array2 = { 4, 1, 10 };
        assertEquals(2, NumberLength.getSmallestNaturalNumber(array2));
    }

    @Test
    public void testSmallerNumberFirstArray() {
        int[] array = { 10, 100 };
        assertEquals(89, NumberLength.getSmallestNaturalNumber(array));

        int[] array2 = { 5, 10 };
        assertEquals(4, NumberLength.getSmallestNaturalNumber(array2));
    }

    @Test
    public void testLargerNumberFirstArray() {
        int[] array = { 100, 10 };
        assertEquals(89, NumberLength.getSmallestNaturalNumber(array));

        int[] array2 = { 10, 5 };
        assertEquals(4, NumberLength.getSmallestNaturalNumber(array2));
    }

    @Test
    public void testAllowOnlyNaturalNumbers() {
        int[] array = { 100, 10, 5, 4, -1 };
        assertThrows(InvalidParameterException.class, () -> {
            NumberLength.getSmallestNaturalNumber(array);
        });
    }

    @Test
    public void testMultibleSameNumbers() {
        int[] array = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 4 };
        assertEquals(4, NumberLength.getSmallestNaturalNumber(array));
    }

    @Test
    public void testTooSmallArray() {
        int[] array = { 10 };
        assertEquals(-1, NumberLength.getSmallestNaturalNumber(array));
    }

    @Test
    public void testEmptyArray() {
        int[] array = {};
        assertEquals(-1, NumberLength.getSmallestNaturalNumber(array));
    }

    @Test
    public void testSameNumberArray() {
        int[] array = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
        assertEquals(0, NumberLength.getSmallestNaturalNumber(array));
    }

    @Test
    public void testNullArray() {
        int[] array = null;
        assertEquals(-1, NumberLength.getSmallestNaturalNumber(array));
    }
}
