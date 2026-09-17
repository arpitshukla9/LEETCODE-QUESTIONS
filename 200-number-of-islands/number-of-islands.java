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
                    // bfs(i, j, grid, visit);
                    dfs(i, j, grid, visit);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visit) {
    int m = grid.length;
    int n = grid[0].length;

    visit[i][j] = true;

    // Up: check i > 0 (not i >= 0)
    if (i > 0 && grid[i - 1][j] == '1' && !visit[i - 1][j]) {
        dfs(i - 1, j, grid, visit);
    }
    // Down: check i < m - 1
    if (i < m - 1 && grid[i + 1][j] == '1' && !visit[i + 1][j]) {
        dfs(i + 1, j, grid, visit);
    }
    // Left: check j > 0
    if (j > 0 && grid[i][j - 1] == '1' && !visit[i][j - 1]) {
        dfs(i, j - 1, grid, visit);
    }
    // Right: check j < n - 1
    if (j < n - 1 && grid[i][j + 1] == '1' && !visit[i][j + 1]) {
        dfs(i, j + 1, grid, visit);
    }
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