package BT7.Bai_5;
// Quicksort In-place (Lomuto Partitioning)
// https://www.hackerrank.com/challenges/quicksort3/problem

import java.io.*;
import java.util.*;

public class Solution {
    static void quickSort(int[] a, int l, int r) {
        if (l >= r) return;              

        int p = partition(a, l, r);         
        printArray(a);                     

        quickSort(a, l, p - 1);            
        quickSort(a, p + 1, r);            
    }

    static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l;                        
        for (int j = l; j < r; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);                   
        return i;                       
    }
    

    static void swap(int[] a, int i, int j) {
        int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
    }

    static void printArray(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(a[i]);
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        sc.close();
    }
}
