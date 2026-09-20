class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] chessBoard = new char[n][n];
        // initialize board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }

        nQueens(0, chessBoard, ans);
        return ans;
    }
    static void nQueens(int row, char[][] chessBoard, List<List<String>> ans) {
        int n = chessBoard.length;
        if (row == n) { // valid answer
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(chessBoard[i][j]);
                }
                list.add(sb.toString());
            }
            ans.add(list);
            return;
        }
        // try every column in current row
        for (int col = 0; col < n; col++) {
            if (canQueenBePlaced(row, col, chessBoard)) {
                chessBoard[row][col] = 'Q';
                // move to next row
                nQueens(row + 1, chessBoard, ans);
                // BACKTRACK
                chessBoard[row][col] = '.';
            }
        }
    }

    static boolean canQueenBePlaced(int row, int col, char[][] chessBoard) {
        // check column
        int i = row - 1;
        while (i >= 0) {
            if (chessBoard[i][col] == 'Q') return false;
            i--;
        }

        // check left diagonal
        i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (chessBoard[i][j] == 'Q') return false;
            i--;
            j--;
        }

        // check right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < chessBoard.length) {
            if (chessBoard[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}