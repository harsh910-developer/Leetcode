class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                char val = board[r][c];

                if(val != '.'){
                    String rowKey = val + "found at row : " + r;
                    String colKey = val + "found at column : " + c;
                    String boxKey = val + "fount at box : " + (r / 3) + "-" + (c / 3);

                    if(!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}