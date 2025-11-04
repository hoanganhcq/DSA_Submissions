package BT5.Bai_7;
// Queue Using Two Stacks
// https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int q = sc.nextInt();
        Stack<Integer> stackNewest = new Stack<>();
        Stack<Integer> stackOldest = new Stack<>();
        
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            switch (type) {
                case 1:
                    int x = sc.nextInt();
                    stackNewest.push(x);
                    break;
                case 2:
                    if (stackOldest.isEmpty()) {
                        while (!stackNewest.isEmpty()) {
                            stackOldest.push(stackNewest.pop());
                        }
                    }
                    stackOldest.pop();
                    break;
                case 3:
                    if (stackOldest.isEmpty()) {
                        while (!stackNewest.isEmpty()) {
                            stackOldest.push(stackNewest.pop());
                        }
                    }
                    System.out.println(stackOldest.peek());
                    break;
            }
        }
        sc.close();
    }
}
