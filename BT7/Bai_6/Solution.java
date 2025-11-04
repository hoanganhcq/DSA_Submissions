package BT7.Bai_6;
// Find the Median (partition)
// https://www.hackerrank.com/challenges/find-the-median/problem

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
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
    // Write your code here
        int k = arr.size() / 2;
        return quickSelect(arr, 0, arr.size() - 1, k);
    }
    
    private static int quickSelect(List<Integer> arr, int l, int r, int k) {
        Random rnd = new Random();
        while (true) {
            if (l == r) return arr.get(l);
            
            int pivotIndex = l + rnd.nextInt(r - l + 1);
            Collections.swap(arr, pivotIndex, r);
            
            int p = partition(arr, l, r);
            
            if (k == p) return arr.get(p);
            else if (k < p) r = p - 1;
            else l = p + 1;
        }
    }
    
    private static int partition(List<Integer> arr, int l, int r) {
        int pivot = arr.get(r);
        int i = l;
        for (int j = l; j < r; j++) {
            if (arr.get(j) < pivot) {
                Collections.swap(arr, i, j);
                i++;
            }
        }
        Collections.swap(arr, i, r);
        return i;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
