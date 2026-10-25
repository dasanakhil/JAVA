import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;

    static int dfs(int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        return 1
            + dfs(r + 1, c)
            + dfs(r - 1, c)
            + dfs(r, c + 1)
            + dfs(r, c - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            grid = new int[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < m; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxArea = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        maxArea = Math.max(maxArea, dfs(i, j));
                    }
                }
            }

            out.append(maxArea).append('\n');
        }

        System.out.print(out);
    }
}
