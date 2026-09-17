class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char val = '1'; val <= '9'; val++) {
                        if (isValid(board, r, c, val)) {
                            board[r][c] = val;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[r][c] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int r, int c, int val) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == val)
                return false;
            if (board[i][c] == val)
                return false;

            int boxRow = 3 * (r / 3) + (i / 3);
            int boxCol = 3 * (c / 3) + (i % 3);

            if (board[boxRow][boxCol] == val)
                return false;
        }
        return true;
    }
}