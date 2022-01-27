// Kristen Klimisch
// CPSC 5031 01
// HW #3 - program

// This program sorts an array of distinct real numbers into ascending order
// using the MergeSort algorithm, which has a time complexity of O(n log n)
// for all input arrays of n elements.

package com.company;

import java.util.Arrays;

public class Inversion {


    // Variable to count the number of tests run & arrays sorted
    // while program is running.
    public static int testCount = 0;

    // Function:    Merge.
    // Purpose:     Merges left and right subarrays of array A[].
    //              Left subarray is A[l..m],
    //              right subarray is A[m+1..r].
    // Parameters:  A[] - the array.
    //              l - the starting index of the left subarray.
    //              m - the ending index of the left subarray.
    //              r - the ending index of the right subarray.
    // Returns:     the count of inversions required to merge the left
    //              and right subarrays of array A[].
    public static int merge(int A[], int l, int m, int r) {

        // Find number of elements in the 2 subarrays to be merged.
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays.
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data from original array A to temp arrays.
        for (int i =0; i < n1; ++i)
            L[i] = A[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = A[m + 1 + j];

        // Merge the temp arrays.

        // Set the starting count of inversions required during the
        // merge step to 0.
        int mergeInversions = 0;

        // Set initial indexes of the left and right subarrays.
        int i = 0, j =0;

        // Set initial index of the array for the merged subarrays.
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j] ) {
                A[k] = L[i];
                i++;
            }
            else {

                // When L[i] > R[j], an inversion is required to
                // sort the array in ascending order.
                // Increment count of inversions.
                mergeInversions++;
                A[k] = R[j];
                j++;

            }
            k++;
        }

        // Copy any remaining elements of left subarray L[]
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements of right subarray R[]
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
        return mergeInversions;
    }

    // Function:    Sort.
    // Purpose:     Divides the input array A[] in half, calls itself on the
    //              2 halves, and then merges the two sorted halves.
    // Parameters:  A[] - the array
    //              l - the starting index of the array.
    //              r - the ending index of the array.
    // Returns:     The count of inversions made to sort the array.
    public static int sort(int A[], int l, int r) {

        // Initialize the count of inversions to 0.
        int count = 0;
        if (l < r){

            // Find the middle point
            int m = l + (r-l)/2;

            // Sort left and right halves of arrays
            count += sort(A, l, m);
            count += sort(A, m + 1, r);

            // Merge the sorted halves.
            count += merge(A, l, m, r);
        }
        return count;
    }

    // Function:    countInversions
    // Purpose:     Sorts the input array and counts the number of
    //              inversions required to sort the input array.
    // Parameters:  A[] - the array
    //              n - the number of elements in the array, which is the
    //              length of the array.
    // Returns:     the number of inversions required to sort the array.
    public static int countInversions(int A[], int n) {

        int inversionCount = 0;
        inversionCount = sort(A, 0, n -1);
        return inversionCount;
    }

    // Function:    Tester.
    // Purpose:     Prints the array before it is processed by the Inversion
    //              sorting function, calls the Inversion sorting function,
    //              prints the sorted array, and prints the count of inversions
    //              returned by the Inversion function.
    // Parameter:   the input array - A
    public static void tester(int[] A){

        // Increment and print the test count #
        testCount++;
        System.out.println("#" + testCount);
        System.out.print("before array = ");
        System.out.println(Arrays.toString(A));
        int inversions = countInversions(A, A.length);
        System.out.print("after array = ");
        System.out.println(Arrays.toString(A));
        System.out.println("inversions = " + inversions);
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{2, 1, 4, 9, 3, 6, 5, 8, 7};
        int[] input2 = new int[]{9, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] input3 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] input4 = new int[]{1, 2, 3, 4, 5, 6, 8, 7, 9};
        int[] input5 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] input6 = new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9};
        int[] input7 = new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 10};
        int[] input8 = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        tester(input1);
        tester(input2);
        tester(input3);
        tester(input4);
        tester(input5);
        tester(input6);
        tester(input7);
        tester(input8);
    }
}
