class Solution {
    public List<Integer> intersection(int[][] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums[0]){
            set.add(i);
        }
        for(int i=1; i<nums.length; i++){
            HashSet<Integer> curr = new HashSet<>();
            for(int j : nums[i]){
                if(set.contains(j)){
                    curr.add(j);
                }
            }
            set = curr;
        }
        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}