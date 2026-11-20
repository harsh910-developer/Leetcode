class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 1;
        for(int num : nums){
            int lenPlusOne = map.getOrDefault(num, 0) + 1;
            int lenSame = map.getOrDefault(num - 1, 0) + 1;

            map.put(num + 1, lenPlusOne);
            map.put(num, lenSame);

            maxLen = Math.max(maxLen, Math.max(lenPlusOne, lenSame));
        }
        return maxLen;
    }
}