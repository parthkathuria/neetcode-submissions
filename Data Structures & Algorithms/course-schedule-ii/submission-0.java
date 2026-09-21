class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            courseMap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            courseMap.get(pre[0]).add(pre[1]);
        }

        Set<Integer> result = new LinkedHashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(i, courseMap, new HashSet<>(), result)) {
                return new int[0];
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean canFinish(
        int i, Map<Integer, List<Integer>> courseMap, Set<Integer> visited, Set<Integer> result) {
        if (visited.contains(i)) {
            return false;
        }
        if (courseMap.get(i).isEmpty()) {
            result.add(i);
            return true;
        }
        visited.add(i);
        List<Integer> prereqs = courseMap.get(i);
        for (int pre : prereqs) {
            if (!canFinish(pre, courseMap, visited, result)) {
                return false;
            }
        }
        visited.remove(i);
        courseMap.put(i, Collections.emptyList());
        result.add(i);
        return true;
    }
}
