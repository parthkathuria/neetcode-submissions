class Solution {
    Set<Integer> cols;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        cols = new HashSet<>();
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();

        board = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = '.';
            }
        }

        List<List<String>> result = new ArrayList<>();
        backtrack(0, result);
        return result;
    }

    private void backtrack(int r, List<List<String>> result) {
        if (r == board.length) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            result.add(copy);
            return;
        }

        for (int c = 0; c < board.length; c++) {
            if (!cols.contains(c) && !posDiag.contains(r + c) && !negDiag.contains(r - c)) {
                cols.add(c);
                posDiag.add(r + c);
                negDiag.add(r - c);
                board[r][c] = 'Q';

                backtrack(r + 1, result);

                cols.remove(c);
                posDiag.remove(r + c);
                negDiag.remove(r - c);
                board[r][c] = '.';
            }
        }
    }
}
