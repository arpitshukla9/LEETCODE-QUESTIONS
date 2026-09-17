class Solution {
    static class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    count++;
                    bfs(i, j, grid, visit);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, char[][] grid, boolean[][] visit) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row, col));
        visit[row][col] = true;

        while (q.size() > 0) {
            Pair front = q.remove();
            int r = front.row, c = front.col;

            // top -> r-1, c
            if (r > 0) {
                if (!visit[r - 1][c] && grid[r - 1][c] == '1') {
                    q.add(new Pair(r - 1, c));
                    visit[r - 1][c] = true;
                }
            }
            // bottom -> r+1, c
            if (r < m - 1) {
                if (!visit[r + 1][c] && grid[r + 1][c] == '1') {
                    q.add(new Pair(r + 1, c));
                    visit[r + 1][c] = true;
                }
            }
            // left -> r, c-1
            if (c > 0) {
                if (!visit[r][c - 1] && grid[r][c - 1] == '1') {
                    q.add(new Pair(r, c - 1));
                    visit[r][c - 1] = true;
                }
            }
            // right -> r, c+1
            if (c < n - 1) {
                if (!visit[r][c + 1] && grid[r][c + 1] == '1') {
                    q.add(new Pair(r, c + 1));
                    visit[r][c + 1] = true;
                }
            }
        }
    }
}