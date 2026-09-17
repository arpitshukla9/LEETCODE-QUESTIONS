class Solution {
    void dfs(int i, boolean[] visit, int[][] connected){
        int n = connected.length;
        visit[i] = true;
            for(int j = 0; j < n; j++){
                if(connected[i][j] == 1 && !visit[j]) {
                    dfs(j, visit, connected);
                }
            }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, isConnected);
                count++;
            }
        }
        return count;
    }
}