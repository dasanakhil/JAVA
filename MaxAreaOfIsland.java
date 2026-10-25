
import java.io.*;   // Import classes for input and output
import java.util.*; // Import StringTokenizer and utilities

public class Main {

    // Declare number of rows and columns
    static int n, m;

    // Declare a 2D array to store the grid
    static int[][] grid;

    // DFS function to calculate the area of an island
    static int dfs(int r, int c) {

        // Check whether:
        // 1. Row is outside the grid
        // 2. Column is outside the grid
        // 3. Current cell contains water (0)
        if (r < 0 || r >= n || c < 0 || c >= m
                || grid[r][c] == 0) {
            return 0; // Invalid cell or water
        }

        // Mark the current land cell as visited
        // by changing 1 to 0
        grid[r][c] = 0;

        // Count current cell as 1
        // and explore all four directions
        return 1
            + dfs(r + 1, c) // Move DOWN
            + dfs(r - 1, c) // Move UP
            + dfs(r, c + 1) // Move RIGHT
            + dfs(r, c - 1); // Move LEFT
    }

    public static void main(String[] args)
            throws Exception {

        // Read input from the keyboard
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        // Read the number of test cases
        int T = Integer.parseInt(br.readLine().trim());

        // Store answers of all test cases
        StringBuilder out = new StringBuilder();

        // Repeat for each test case
        while (T-- > 0) {

            // Read number of rows and columns
            StringTokenizer st =
                new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // Create a grid of n rows and m columns
            grid = new int[n][m];

            // Read all elements of the grid
            for (int i = 0; i < n; i++) {

                // Read one row of the grid
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < m; j++) {

                    // Store each element in the grid
                    grid[i][j] =
                        Integer.parseInt(st.nextToken());
                }
            }

            // Variable to store the largest island area
            int maxArea = 0;

            // Visit every cell in the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    // Start DFS only if land (1) is found
                    if (grid[i][j] == 1) {

                        // Calculate island area
                        // and update maximum area
                        maxArea = Math.max(
                            maxArea, dfs(i, j)
                        );
                    }
                }
            }

            // Store the result followed by a new line
            out.append(maxArea).append('\n');
        }

        // Print answers for all test cases
        System.out.print(out);
    }
}
