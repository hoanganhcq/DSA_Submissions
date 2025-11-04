package BT5.Bai_6;
// Simple Text Editor
// https://www.hackerrank.com/challenges/simple-text-editor/problem

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        StringBuilder s = new StringBuilder();
        Stack<String> history = new Stack<>();
        
        for (int i = 0; i < Q; i++) {
            int type = sc.nextInt();
            switch (type) {
                case 1:
                    history.push(s.toString());
                    s.append(sc.next());
                    break;
                case 2:
                    history.push(s.toString());
                    int k = sc.nextInt();
                    s.delete(s.length() - k, s.length());
                    break;
                case 3:
                    int position = sc.nextInt();
                    System.out.println(s.charAt(position - 1));
                    break;
                case 4:
                    if (!history.isEmpty()) {
                        s = new StringBuilder(history.pop());
                    }
                    break;
            }
        }
        sc.close();
    }
}
