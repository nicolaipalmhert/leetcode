class Solution {
    public boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];

        for (int stones = 1; stones <= n; stones++) {

            for (int i = 1; i * i <= stones; i++) {

                int square = i * i;

                if (!dp[stones - square]) {
                    dp[stones] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
