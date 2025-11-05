package BT12.Bai_1;
// Connect Cells in a Grid
// https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem

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
    
    static int[][] grid;
    static boolean[][] visited;
    static int N, M;
    
    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(List<List<Integer>> matrix) {
    // Write your code here
        N = matrix.size();
        if (N == 0) return 0;
        M = matrix.get(0).size();
        
        grid = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            List<Integer> row = matrix.get(i);
            for (int j = 0; j < M; j++) {
                grid[i][j] = row.get(j);
            }
        }
        
        int best = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    best = Math.max(best, dfsCount(r, c));
                }
            }
        }
        return best;
    }

    
    private static int dfsCount(int r, int c) {
        visited[r][c] = true;
        int cnt = 1;
        
        int[] dr = {-1,-1,-1, 0,0, 1,1,1};
        int[] dc = {-1, 0, 1,-1,1,-1,0,1};
        
        for (int k = 0; k < 8; k++){
            int nr = r + dr[k];
            int nc = c + dc[k];
            
            if (nr >= 0 && nr < N && nc >= 0 && nc < M &&
            grid[nr][nc] == 1 && !visited[nr][nc]) {
                cnt += dfsCount(nr, nc);
            }
        }
        return cnt;
    }


    private static int bfsCount(int sr, int sc) {
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        Deque<int[]> q = new ArrayDeque<>();
        visited[sr][sc] = true;
        q.add(new int[]{sr, sc});
        int cnt = 0;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            cnt++;
            int r = curr[0], c = curr[1];
            
            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M
                && grid[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                } 
            }
        }
        return cnt;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
