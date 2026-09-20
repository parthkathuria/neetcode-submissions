class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
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

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                continue;
            }
            currComb.add(nums[j]);
            dfs(j, nums, total + nums[j], target, currComb, result);

            currComb.removeLast();
        }
    }
}
