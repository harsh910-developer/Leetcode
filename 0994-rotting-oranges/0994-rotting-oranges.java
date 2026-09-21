class Solution {
    public static final int[][] dirs = {
        {-1, 0},
        {1,0},
        {0,-1},
        {0, 1}
    };
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0, count = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;

        int num, x, y;

        while(!q.isEmpty()){
            num = q.size();
            for(int i=0; i<num; i++){
                int[] curr = q.poll();
                x = curr[0];
                y = curr[1];

                for(int[] dir : dirs){
                    int nr = x + dir[0];
                    int nc = y + dir[1];

                    if(nr < 0 || nr >= m || nc < 0 || nc >= n){
                        continue;
                    }
                    if(grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            if(!q.isEmpty()){
                count++;
            }
        }
        if(fresh == 0){
            return count;
        }
        return -1;
    }
}