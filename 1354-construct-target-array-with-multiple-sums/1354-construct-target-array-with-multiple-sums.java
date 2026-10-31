class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for(int num : target){
            pq.offer((long) num);
            sum += num;
        }
        while(true){
            long largest = pq.poll();
            long remaining = sum - largest;
            if(largest == 1 || remaining == 1){
                return true;
            }
            if(remaining == 0 || largest <= remaining){
                return false;
            }
            long previous = largest % remaining;
            if(previous == 0){
                return false;
            }
            sum = remaining + previous;
            pq.offer(previous);
        }
    }
}