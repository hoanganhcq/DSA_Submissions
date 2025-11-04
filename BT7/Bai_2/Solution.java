package BT7.Bai_2;
// Computing the GCD
// https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd/problem

import java.io.*;
import java.util.*;

public class Solution {
    
    public static int gcd(int a, int b) {
        
        if (b == 0) {
            if (a == 0) return 1;
            return Math.abs(a);
        } else return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        System.out.println(gcd(a, b));
        
        sc.close();    
    }
}
