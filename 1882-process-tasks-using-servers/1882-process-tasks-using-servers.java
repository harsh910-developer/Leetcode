class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> available = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        );
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return Long.compare(a[0], b[0]);
                if (a[1] != b[1]) return Long.compare(a[1], b[1]);
                return Long.compare(a[2], b[2]);
            }
        );
        for(int i=0; i<servers.length; i++){
            available.offer(new int[]{servers[i], i});
        }
        int[] ans = new int[tasks.length];
        long time = 0;

        for(int j=0; j<tasks.length; j++){
            time = Math.max(time, j);
            while(!busy.isEmpty() && busy.peek()[0] <= time){
                long[] server = busy.poll();
                available.offer(new int[]{(int) server[1], (int) server[2]});
            }
            if(available.isEmpty()){
                time = busy.peek()[0];
                while(!busy.isEmpty() && busy.peek()[0] <= time){
                    long[] server = busy.poll();
                    available.offer(new int[]{(int) server[1], (int) server[2]});
                }
            }
            int[] server = available.poll();
            int weight = server[0];
            int idx = server[1];
            ans[j] = idx;
            busy.offer(new long[]{time+tasks[j], weight, idx});
        }
        return ans;
    }
}