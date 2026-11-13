class Solution {
    static class Pair{
        int val, count;
        Pair(int val, int count){
            this.val = val;
            this.count = count;
        }
    }
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        Deque<Pair> dq = new ArrayDeque<>();
        long cost = 0;
        int r = n-1;

        for (int l = n-1; l >= 0; l--) {
            int num = nums[l];
            long operation = 0;
            int count = 1;
            while(!dq.isEmpty() && dq.peekLast().val < num){
                Pair p = dq.pollLast();
                count += p.count;
                cost += (long) (num - p.val) * p.count;
            }
            dq.addLast(new Pair(num, count));
            while(cost > k){
                Pair p = dq.peekFirst();
                cost -= (p.val - nums[r]);
                if(p.count == 1){
                    dq.pollFirst();
                }else{
                    p.count--;
                }
                r--;
            }
            ans += r - l+1;
        }
        return ans;
    }
}