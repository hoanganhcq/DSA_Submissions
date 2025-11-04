package BT5.Bai_3;
// Java ArrayList
// https://www.hackerrank.com/challenges/java-arraylist/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                int num = sc.nextInt();
                row.add(num);
            }
            arr.add(row);
        }
        
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            if (x < 1 || x > arr.size() || y < 1 || y > arr.get(x - 1).size()) {
                System.out.println("ERROR!");
            } else {
                System.out.println(arr.get(x - 1).get(y - 1));
            }
        }
        
        sc.close();
    }
}

