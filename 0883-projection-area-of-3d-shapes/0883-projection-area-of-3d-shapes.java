class Solution {
    public int projectionArea(int[][] grid) {
        int area = 0;
        for(int i=0; i<grid.length; i++){
            int row = 0;
            int col = 0;
            for(int j=0; j<grid.length; j++){
                // top view
                if(grid[i][j] > 0){
                    area++;
                }
                row = Math.max(row, grid[i][j]);
                col = Math.max(col, grid[j][i]);
            }
            area += row;
            area += col;
        }
        return area;
    }
}