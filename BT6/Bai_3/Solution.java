package BT6.Bai_3;
// Insertion Sort - Part 1
// https://www.hackerrank.com/challenges/insertionsort1/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
        for (int i = n - 1; i >= 1; i--) {
            int position = i - 1;
            int curr = arr.get(i);
            while (position >= 0 && arr.get(position) > curr) {
                arr.set(position + 1, arr.get(position));
                position--;
                for (int a : arr) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            arr.set(position + 1, curr);
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}