class Solution {
    public static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] grid, boolean[][] visited, int r, int c, int pr, int pc, int target){
        visited[r][c] = true;

        for(int[] d : dirs){
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) {
                continue;
            }
            if(grid[nr][nc] != target){
                continue;
            }
            if(nr == pr && nc == pc){
                continue;
            }
            if(visited[nr][nc]){
                return true;
            }
            if(dfs(grid, visited, nr, nc, r, c, target)){
                return true;
            }
        }
        return false;
    }
}