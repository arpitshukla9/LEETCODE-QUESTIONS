class Solution {
    private void bfs(int start, List<List<Integer>> rooms, boolean[] visit, int n) {
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.add(start);
        
        while (q.size() > 0) {
            int front = q.remove();
            for (int ele : rooms.get(front)) {
                if (!visit[ele]) {
                    visit[ele] = true;
                    q.add(ele);
                }
            }
        }
    }

    private void dfs(int start, List<List<Integer>> rooms, boolean[] visit) {
        visit[start] = true;
        for(int ele : rooms.get(start)) {
            if(!visit[ele]) dfs(ele, rooms , visit);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visit = new boolean[n];
        
        // bfs(0, rooms, visit, n);
        dfs(0, rooms, visit);
        
        for (boolean ele : visit) {
            if (!ele) return false;
        }
        return true;
    }
}