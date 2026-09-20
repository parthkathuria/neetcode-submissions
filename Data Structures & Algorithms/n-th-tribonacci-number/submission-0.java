class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return n;
        }
        if (n <= 2) {
            return 1;
        }
        int zero = 0;
        int one = 1;
        int two = 1;

        for (int i = 3; i <= n; i++) {
            int next = zero + one + two;
            zero = one;
            one = two;
            two = next;
        }
        return two;
    }
}