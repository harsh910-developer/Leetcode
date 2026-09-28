class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num % k == 0){
                set.add(num / k);
            }
        }
        int i = 1;
        while(true){
            if(!set.contains(i)){
                return i * k;
            }
            i++;
        }
    }
}