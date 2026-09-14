class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backTrack(nums, 0, current, result);

        return result;
    }
    public void backTrack(int[] arr, int index, List<Integer> curr, List<List<Integer>> result){

        result.add(new ArrayList<>(curr));

        for(int i=index; i<arr.length; i++){
            curr.add(arr[i]);
            backTrack(arr, i+1, curr, result);

            curr.remove(curr.size() - 1);
        }
    }

}