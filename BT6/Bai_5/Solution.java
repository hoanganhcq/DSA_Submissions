package BT6.Bai_5;
// Correctness Invariant
// https://www.hackerrank.com/challenges/correctness-invariant/problem

import java.io.*;
import java.util.*;

public class Solution {
    public static void insertionSort(List<Integer> arr) {
        int n = arr.size();
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++) {
            int pos = i + 1;
            int curr = arr.get(pos);
            while (pos > 0 && arr.get(pos - 1) > curr) {
                arr.set(pos, arr.get(pos - 1));
                pos--; 
            }
            arr.set(pos, curr);
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int s = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            int num = sc.nextInt();
            arr.add(num);
        }
        insertionSort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
        
        sc.close();
    }
}
