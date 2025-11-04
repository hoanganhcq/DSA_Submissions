package BT9.Bai_7;
// Clossest Numbers (Merge Sort)
// https://www.hackerrank.com/challenges/closest-numbers/problem

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

    public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
        int n = arr.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = arr.get(i);

        int[] tmp = new int[n];
        mergeSort(a, 0, n - 1, tmp);

        List<Integer> res = new ArrayList<>();
        long minDiff = Long.MAX_VALUE;

        for (int i = 0; i + 1 < n; i++) {
            long diff = (long) a[i + 1] - a[i];
            if (diff < minDiff) {
                minDiff = diff;
                res.clear();
                res.add(a[i]); res.add(a[i + 1]);
            } else if (diff == minDiff) {
                res.add(a[i]); res.add(a[i + 1]);
            }
        }
        return res;
    }

    // merge sort
    private static void mergeSort(int[] a, int l, int r, int[] tmp) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(a, l, m, tmp);
        mergeSort(a, m + 1, r, tmp);
        merge(a, l, m, r, tmp);
    }
    
    private static void merge(int[] a, int l, int m, int r, int[] tmp) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (a[i] <= a[j]) tmp[k++] = a[i++];
            else tmp[k++] = a[j++];
        }
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        for (int t = l; t <= r; t++) a[t] = tmp[t];
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

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
