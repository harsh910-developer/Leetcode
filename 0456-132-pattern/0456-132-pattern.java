class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int second = Integer.MIN_VALUE;

        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] < second){
                return true;
            }
            while(!stk.isEmpty() && nums[i] > stk.peek()){
                second = stk.pop();
            }
            stk.push(nums[i]);
        }
        return false;
    }
}