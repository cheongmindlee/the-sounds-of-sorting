package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public static Integer[] makeEmptyArray(){
        return new Integer[]{};
    }

    public static Integer[] makeAscendingArray(){
        return new Integer[]{
            1, 2, 3, 4, 5
        };
    }

    public static Integer[] makeDescendingArray(){
        return new Integer[]{
            5, 4, 3, 2, 1
        };
    }

    public static Integer[] makeDuplicateArray(){
        return new Integer[]{
            1, 1, 1, 1, 5, 5, 5, 2, 2, 2, 2
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {

        //See if eventSort works
        Integer[] arr = makeTestArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);

        List<SortEvent<Integer>> l = Sorts.bubbleSort(arr);
        Sorts.eventSort(copyArr, l);
        assertArrayEquals(copyArr, arr);
        //Test if sort worked for random array
        testSort(Sorts::bubbleSort);

        //Test for empty arrays
        Integer[] empty = makeEmptyArray();
        Sorts.bubbleSort(empty);
        assertArrayEquals(makeEmptyArray(), empty);

        //Test for Ascending Order
        Integer[] ascending = makeAscendingArray();
        Sorts.bubbleSort(ascending);
        assertArrayEquals(makeAscendingArray(), ascending);

        //Test for Descending Order
        Integer[] descending = makeDescendingArray();
        Sorts.bubbleSort(descending);
        assertArrayEquals(ascending, descending);

        //Test for Duplicate's inside array
        Integer[] duplicates = makeDuplicateArray();
        Sorts.bubbleSort(duplicates);
        Integer[] sortedDuplicates = {1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5};
        assertArrayEquals(sortedDuplicates, duplicates);
    }
    
    @Test
    public void testInsertionSort() {
        //See if eventSort works
        Integer[] arr = makeTestArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);

        List<SortEvent<Integer>> l = Sorts.insertionSort(arr);
        Sorts.eventSort(copyArr, l);
        assertArrayEquals(arr, copyArr);

        //For given array
        testSort(Sorts::insertionSort);

         //Test for empty arrays
        Integer[] empty = makeEmptyArray();
        Sorts.insertionSort(empty);
        assertArrayEquals(makeEmptyArray(), empty);

        //Test for Ascending Order
        Integer[] ascending = makeAscendingArray();
        Sorts.insertionSort(ascending);
        assertArrayEquals(makeAscendingArray(), ascending);

        //Test for Descending Order
        Integer[] descending = makeDescendingArray();
        Sorts.insertionSort(descending);
        assertArrayEquals(ascending, descending);

        //Test for Duplicate's inside array
        Integer[] duplicates = makeDuplicateArray();
        Sorts.insertionSort(duplicates);
        Integer[] sortedDuplicates = {1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5};
        assertArrayEquals(sortedDuplicates, duplicates);
    }
    
    @Test
    public void testSelectionSort() {
        //See if eventSort works
        Integer[] arr = makeTestArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);

        List<SortEvent<Integer>> l = Sorts.selectionSort(arr);
        Sorts.eventSort(copyArr, l);
        assertArrayEquals(arr, copyArr);

        //See if it is sorted using given function and arr
        testSort(Sorts::selectionSort);

        //Test for empty arrays
        Integer[] empty = makeEmptyArray();
        Sorts.selectionSort(empty);
        assertArrayEquals(makeEmptyArray(), empty);

        //Test for Ascending Order
        Integer[] ascending = makeAscendingArray();
        Sorts.selectionSort(ascending);
        assertArrayEquals(makeAscendingArray(), ascending);

        //Test for Descending Order
        Integer[] descending = makeDescendingArray();
        Sorts.selectionSort(descending);
        assertArrayEquals(ascending, descending);

        //Test for Duplicate's inside array
        Integer[] duplicates = makeDuplicateArray();
        Sorts.selectionSort(duplicates);
        Integer[] sortedDuplicates = {1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5};
        assertArrayEquals(sortedDuplicates, duplicates);
    }

    @Test
    public void testMergeSort() {
        //See if eventSort works
        Integer[] arr = makeTestArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);

        List<SortEvent<Integer>> l = Sorts.mergeSort(arr);
        Sorts.eventSort(copyArr, l);
        assertArrayEquals(arr, copyArr);

        //See if it is sorted using given function and arr
        testSort(Sorts::mergeSort);

        //Test for empty arrays
        Integer[] empty = makeEmptyArray();
        Sorts.mergeSort(empty);
        assertArrayEquals(makeEmptyArray(), empty);

        // //Test for Ascending Order
        Integer[] ascending = makeAscendingArray();
        Sorts.mergeSort(ascending);
        assertArrayEquals(makeAscendingArray(), ascending);

        //Test for Descending Order
        Integer[] descending = makeDescendingArray();
        Sorts.mergeSort(descending);
        assertArrayEquals(ascending, descending);

        //Test for Duplicate's inside array
        Integer[] duplicates = makeDuplicateArray();
        Sorts.mergeSort(duplicates);
        Integer[] sortedDuplicates = {1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5};
        assertArrayEquals(sortedDuplicates, duplicates);
    }
    
    @Test
    public void testQuickSort() {
        //See if eventSort works
        Integer[] arr = makeTestArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);

        List<SortEvent<Integer>> l = Sorts.quickSort(arr);
        Sorts.eventSort(copyArr, l);
        assertArrayEquals(arr, copyArr);

        //See if it is sorted using given function and arr
        testSort(Sorts::quickSort);

         //Test for empty arrays
        Integer[] empty = makeEmptyArray();
        Sorts.quickSort(empty);
        assertArrayEquals(makeEmptyArray(), empty);

        //Test for Ascending Order
        Integer[] ascending = makeAscendingArray();
        Sorts.quickSort(ascending);
        assertArrayEquals(makeAscendingArray(), ascending);

        //Test for Descending Order
        Integer[] descending = makeDescendingArray();
        Sorts.quickSort(descending);
        assertArrayEquals(ascending, descending);

        //Test for Duplicate's inside array
        Integer[] duplicates = makeDuplicateArray();
        Sorts.quickSort(duplicates);
        Integer[] sortedDuplicates = {1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5};
        assertArrayEquals(sortedDuplicates, duplicates);
    }
}