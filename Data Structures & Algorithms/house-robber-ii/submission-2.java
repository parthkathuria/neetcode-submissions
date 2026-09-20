class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(calculate(Arrays.copyOfRange(nums, 0, nums.length - 1)),
            calculate(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int calculate(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        for (int n : nums) {
            int newRob = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    }
}
