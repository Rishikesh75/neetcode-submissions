class Solution {

    int rows, cols;

    public void dfs(int row, int col, boolean[][] visited, int[][] heights) {

        visited[row][col] = true;

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Boundary check
            if (newRow < 0 || newCol < 0 ||
                    newRow >= rows || newCol >= cols) {
                continue;
            }

            // Already visited
            if (visited[newRow][newCol]) {
                continue;
            }

            // Water can flow from higher/equal to lower
            // Reverse DFS condition
            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(newRow, newCol, visited, heights);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> ans = new ArrayList<>();

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific DFS
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacific, heights);
        }

        for (int j = 0; j < cols; j++) {
            dfs(0, j, pacific, heights);
        }

        // Atlantic DFS
        for (int i = 0; i < rows; i++) {
            dfs(i, cols - 1, atlantic, heights);
        }

        for (int j = 0; j < cols; j++) {
            dfs(rows - 1, j, atlantic, heights);
        }

        // Find cells reachable from both
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}