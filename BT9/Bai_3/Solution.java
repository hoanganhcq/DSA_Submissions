package BT9.Bai_3;
// Java HashSet
// https://www.hackerrank.com/challenges/java-hashset/problem

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        in.nextLine();
        
        Set<String> pairs = new HashSet<>();
        
        for (int i = 0; i < t; i++) {
            String first = in.next();
            String second = in.next();
            String pair = first + "-" + second;
            
            pairs.add(pair);
            System.out.println(pairs.size());
        }
        
        in.close();
    }
}
