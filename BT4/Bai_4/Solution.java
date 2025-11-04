package BT4.Bai_4;
// Sherlock and Array
// https://www.hackerrank.com/challenges/sherlock-and-array/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Collections;

class Result {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
    // Write your code here
        int n = arr.size();
        List<Integer> preSum = new ArrayList<>(Collections.nCopies(n, 0));
        preSum.set(0, arr.get(0));
        for (int i = 1; i < n; i++) {
            preSum.set(i, preSum.get(i - 1) + arr.get(i));
        }
        

        for (int i = 0; i < n; i++) {
            int lSum = (i == 0) ? 0 : preSum.get(i - 1);
            int rSum = preSum.get(n - 1) - preSum.get(i);
            if (lSum == rSum) return "YES";
        }
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        for (int TItr = 0; TItr < T; TItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            String result = Result.balancedSums(arr);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
