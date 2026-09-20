class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        nQueens(0,board, ans);
        return ans;
    }
    void nQueens(int row , char[][] board, List<List<String>> ans){
        int n = board.length;
        if(row == n){
            List<String> list = new ArrayList<>();
            for(char[] c : board) list.add(new String(c));
            ans.add(list);
            return;
        }
        for(int col =  0; col < n; col++){
            if(canPlaceQueen(row, col, board)){
                // place
                board[row][col] = 'Q';
                // explore
                nQueens(row+1,board, ans);
                // undo 
                board[row][col] = '.';
            }
        }
    }
    boolean canPlaceQueen(int row ,int col, char[][] board){
        int n = board.length;
        //column
        int i = row - 1;
        while(i >= 0){
            if(board[i][col] == 'Q') return false;
            i--;
        }
        // left diagonal
        i = row - 1;
        int j = col - 1;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        // right diagonal
        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < n){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}