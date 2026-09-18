class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        StringBuilder currIp = new StringBuilder();
        backtrack(s, 0, 0, currIp, result);
        return result;
    }

    public void backtrack(String s, int i, int dots, StringBuilder currIp, List<String> result) {
        if (dots == 4 && i == s.length()) {
            result.add(currIp.substring(0, currIp.length() - 1).toString()); // remove last dot
            return;
        }
        if (dots > 4) {
            return;
        }
        for (int j = i; j < Math.min(i + 3, s.length()); j++) {
            if (i != j && s.charAt(i) == '0') {
                continue;
            }
            int ip = Integer.parseInt(s.substring(i, j + 1));
            if (ip <= 255) {
                int lengthBefore = currIp.length();
                currIp.append(s.substring(i, j + 1)).append(".");
                backtrack(s, j + 1, dots + 1, currIp, result);
                currIp.setLength(lengthBefore); // restore string to before ip and dot appended
            }
        }
    }
}