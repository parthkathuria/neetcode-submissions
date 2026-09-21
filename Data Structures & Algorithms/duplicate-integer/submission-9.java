class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dups = new HashSet<>();
        for (int num : nums) {
            if (dups.contains(num)) {
                return true;
            }
            dups.add(num);
        }
        return false;
    }
}