class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sorted = new int[n][3];
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        int[] result = new int[n];
        int resultIdx = 0;
        int i = 0;
        long currentTime = 0;

        while (resultIdx < n) {
            while (i < n && sorted[i][0] <= currentTime) {
                heap.offer(sorted[i]);
                i++;
            }

            if (heap.isEmpty()) {
                currentTime = sorted[i][0];
                while (i < n && sorted[i][0] <= currentTime) {
                    heap.offer(sorted[i]);
                    i++;
                }
            }
            int[] task = heap.poll();
            result[resultIdx++] = task[2];
            currentTime += task[1];
        }

        return result;
    }
}