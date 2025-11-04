package BT5.Bai_2;
// Java List
// https://www.hackerrank.com/challenges/java-list/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr.add(num);
        }
        
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            sc.nextLine();
            String query = sc.nextLine();
            if (query.equals("Insert")) {
                int pos = sc.nextInt();
                int num = sc.nextInt();
                arr.add(pos, num);
            } else if (query.equals("Delete")){
                int pos = sc.nextInt();
                arr.remove(pos);
            }
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
        
        sc.close();
    }
}

