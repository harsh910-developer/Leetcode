class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        List<int[]> one1 = new ArrayList<>();
        List<int[]> one2 = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(img1[i][j] == 1){
                    one1.add(new int[]{i, j});
                }
                if(img2[i][j] == 1){
                    one2.add(new int[]{i, j});
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();

        int maxOverlap = 0;

        for(int[] p1 : one1){
            for(int[] p2 : one2){
                int shiftRow = p2[0] - p1[0];
                int shiftCol = p2[1] - p1[1];

                String key = shiftRow + ", " + shiftCol;

                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);
                maxOverlap = Math.max(maxOverlap, count);
            }
        }
        return maxOverlap;
    }
}