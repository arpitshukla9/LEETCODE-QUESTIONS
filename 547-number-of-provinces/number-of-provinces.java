class Solution {
    void bfs(int i, boolean[] visit, int[][] connected, int n){
        // bfs (i) mark it true
        visit[i] = true;
        // Create a Queue
        Queue<Integer> q = new LinkedList<>();
        // add i first
        q.add(i);
        while(q.size() > 0){
            int front = q.remove();
            for(int j = 0; j < n; j++){
                if(connected[front][j] == 1 && !visit[j]) {
                    q.add(j);
                    visit[j] = true;
                }
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean visited[] = new boolean [n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(i, visited, isConnected, n);
                count++;
            }
        }
        return count;
    }
}