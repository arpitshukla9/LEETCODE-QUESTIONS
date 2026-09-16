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

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visit = new boolean[n];
        
        bfs(0, rooms, visit, n);
        
        for (boolean ele : visit) {
            if (!ele) return false;
        }
        return true;
    }
}