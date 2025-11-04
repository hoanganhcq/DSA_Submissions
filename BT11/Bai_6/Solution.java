package BT11.Bai_6;
// Find the Running Median (BST)
// https://www.hackerrank.com/challenges/find-the-running-median/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    
    static class Node {
        int val;
        int idx;
        Node(int v, int i) { 
            val = v; idx = i; 
        }
    }
    
    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Using TreeSet as a BST (stores nodes in sorted order)
        TreeSet<Node> set = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node x, Node y) {
                if (x.val != y.val) return Integer.compare(x.val, y.val);
                return Integer.compare(x.idx, y.idx); // ensures unique ordering
            }
        });

        List<Double> result = new ArrayList<>();
        Node midL = null, midR = null; // left and right median pointers

        for (int i = 0; i < a.size(); i++) {
            Node current = new Node(a.get(i), i);
            int sizeBefore = set.size();
            set.add(current);

            if (sizeBefore == 0) {
                midL = midR = current;
            } 
            else if (sizeBefore % 2 == 1) {
                Node oldMid = midL; // (midL == midR)
                if (set.comparator().compare(current, oldMid) <= 0) {
                    midL = set.lower(oldMid);
                    midR = oldMid;
                } else {
                    midL = oldMid;
                    midR = set.higher(oldMid);
                }
            } 
            else {
                if (set.comparator().compare(current, midL) <= 0) {
                    midL = midR = midL;
                } else if (set.comparator().compare(current, midR) >= 0) {
                    midL = midR = midR;
                } else {
                    midL = midR = current;
                }
            }

            // calc median
            if (set.size() % 2 == 1) {
                result.add((double) midL.val);
            } else {
                result.add((midL.val + midR.val) / 2.0);
            }
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        List<Double> result = Result.runningMedian(a);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
