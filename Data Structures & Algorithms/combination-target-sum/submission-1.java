class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int i, int[] nums, int total, int target, List<Integer> currComb,
        List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(currComb));
            return;
        }
        if (total > target || i >= nums.length) {
            return;
        }

        currComb.add(nums[i]);
        dfs(i, nums, total + nums[i], target, currComb, result);

        currComb.removeLast();
        dfs(i + 1, nums, total, target, currComb, result);
    }
}
