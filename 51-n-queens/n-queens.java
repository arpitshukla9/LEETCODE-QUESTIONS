class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        nQueens(0, board, ans);
        return ans;
    }

    private void nQueens(int row, char[][] board, List<List<String>> ans) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();

            for (char[] r : board)
                list.add(new String(r));

            ans.add(list);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (canPlace(row, col, board)) {
                board[row][col] = 'Q';
                nQueens(row + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    private boolean canPlace(int row, int col, char[][] board) {

        // column
        int i = row - 1;
        while (i >= 0) {
            if (board[i][col] == 'Q')
                return false;
            i--;
        }

        // left diagonal
        i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }

        // right diagonal
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }

        return true;
    }
}