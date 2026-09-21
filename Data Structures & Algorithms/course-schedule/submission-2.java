class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int[] prereq : prerequisites) {
            courseMap.computeIfAbsent(prereq[0], k -> new ArrayList<>()).add(prereq[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!finish(i, courseMap, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    private boolean finish(int n, Map<Integer, List<Integer>> courseMap, Set<Integer> visited) {
        if (visited.contains(n)) {
            return false;
        }
        if (!courseMap.containsKey(n)) {
            return true;
        }
        visited.add(n);
        List<Integer> prereqs = courseMap.get(n);
        for (int prereq : prereqs) {
            if (!finish(prereq, courseMap, visited)) {
                return false;
            }
        }
        visited.remove(n);
        courseMap.remove(n);
        return true;
    }
}
