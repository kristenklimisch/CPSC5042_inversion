// Kristen Klimisch
// CPSC 5031 01
// HW #3 - program

// This program sorts an array of distinct numbers into ascending order
// using the MergeSort algorithm, which has a time complexity of O(n log n)
// for all input arrays of n elements.

package com.company;

import java.util.Arrays;

public class Inversion {


    // Variable to count the number of tests run & arrays sorted
    // while program is running.
    public static int testCount = 0;

    // Function:    Merge.
    // Purpose:     Merges left and right subarrays of A[].
    //              Left subarray is A[l..m],
    //              right subarray is A[m+1..r].
    // Parameters:  A[] - the array.
    //              l - the starting index of the left subarray.
    //              m - the ending index of the left subarray.
    //              r - the ending index of the right subarray.
    public static void merge(int A[], int l, int m, int r) {
        // Find number of elements in 2 subarrays to be merged.
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
    }

    public static void sort(int A[], int l, int r) {
        if (l < r){
            // Find the middle point
            int m = l + (r-1)/2;

            // Sort left and right halves of arrays
            sort(A, l, m);
            sort(A, m + 1, r);

            // Merge the sorted halves
            merge(A, l, m, r);
        }
    }

    public static int countInversions(int A[], int n) {
        // how am I counting the number of inversions?
        // and what is input variable n?
        sort(A, 0, A.length - 1);

        return 1;
    }

    // Function:    tester.
    // Purpose:     prints the array before being processed by the Inversion
    //              sorting function, calls the Inversion sorting function,
    //              prints the sorted array, and prints the count of inversions
    //              returned by the Inversion function.
    // Parameter:   the input array - A
    public static void tester(int[] A){

        // Increment and print the test count #
        testCount++;
        System.out.println("#" + testCount);
        System.out.print("before array =");
        System.out.println(Arrays.toString(A));
        int inversions = countInversions(A, 0);
        System.out.print("after array =");
        System.out.println(Arrays.toString(A));
        System.out.println("inversions = " + inversions);
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,1,4,9,3,6,5,8,7};
        tester(input);
    }
}
