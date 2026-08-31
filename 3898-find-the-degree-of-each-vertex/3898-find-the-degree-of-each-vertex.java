class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] result = new int[matrix.length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    result[j]++;
                }
            }
        }
        return result;
    }
}