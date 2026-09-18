class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int maxLen = 0;
        int duplicates = 0;
        int localMax = 0;
        if (n <= 2) {
            return n;
        }
        for(int i=0; i<n; i++){
            HashMap<Double, Integer> map = new HashMap<>();
            for(int j=i+1; j<n; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];
                
                if (x1 == x2 && y1 == y2) {
                    duplicates++;
                    continue;
                }

                double slope;

                if(x2 == x1){
                    slope = Double.POSITIVE_INFINITY;
                }else{
                    slope = (double) (y2 - y1) / (x2-x1);
                    
                    if (slope == -0.0) {
                        slope = 0.0;
                    }
                }

                map.put(slope, map.getOrDefault(slope, 0) + 1);
                maxLen = Math.max(maxLen, map.get(slope) + 1);
            }
        }
        return maxLen;
    }
}