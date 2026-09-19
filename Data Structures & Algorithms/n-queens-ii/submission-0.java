class Solution {
    Set<Integer> cols;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    int result;

    public int totalNQueens(int n) {
        cols = new HashSet<>();
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();
        result = 0;

        backtrack(0, n);

        return result;
    }

    private void backtrack(int r, int n) {
        if (r == n) {
            result++;
            return;
        }
        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);

            backtrack(r + 1, n);

            cols.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
        }
    }
}