class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        dfs(0, candidates, 0, target, new ArrayList<>());
        return result;
    }

    public void dfs(int i, int[] candidates, int total, int target, List<Integer> currComb) {
        if (total == target) {
            result.add(new ArrayList<>(currComb));
            return;
        }
        if (total > target || i >= candidates.length) {
            return;
        }

        currComb.add(candidates[i]);
        dfs(i + 1, candidates, total + candidates[i], target, currComb);
        currComb.removeLast();
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(i + 1, candidates, total, target, currComb);
    }
}
