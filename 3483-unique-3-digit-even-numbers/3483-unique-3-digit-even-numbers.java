class Solution {
    HashSet<Integer> set = new HashSet<>();
    public void permute(int[] nums, boolean[] used, int num, int length){
        if(length == 3){
            if(num % 2 == 0){
                set.add(num);
            }
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            if(length == 0 && nums[i] == 0) continue;
            used[i] = true;

            permute(nums, used, num*10 + nums[i], length+1);

            used[i] = false;
        }
    }
    public int totalNumbers(int[] digits) {
        boolean[] used = new boolean[digits.length];
        permute(digits, used, 0, 0);
        return set.size();
    }
}