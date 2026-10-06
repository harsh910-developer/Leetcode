class Solution {
    public void backTrack(List<List<Integer>> result, List<Integer> curr, int[] arr, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            curr.add(arr[i]);
            backTrack(result, curr, arr, target - arr[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backTrack(result, curr, candidates, target, 0);
        return result;
    }
}