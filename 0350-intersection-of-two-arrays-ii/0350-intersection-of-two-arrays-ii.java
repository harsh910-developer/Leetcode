class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        int idx = 0;
        for(int num : nums1){
            count[num]++;
        }
        List<Integer> l = new ArrayList<>();
        for(int num : nums2){
            if(count[num] > 0){
                l.add(num);
                count[num]--;
            }
        }
        
        int[] ans = new int[l.size()];
        for(int i=0; i<l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}