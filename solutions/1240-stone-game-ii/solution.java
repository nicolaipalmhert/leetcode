class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // suffix[i] = total stones from i to the end
        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        int[][] memo = new int[n][n + 1];

        return solve(piles, 0, 1, suffix, memo);
    }

    private int solve(int[] piles, int index, int M, int[] suffix, int[][] memo) {
        int n = piles.length;

        // no piles left
        if (index >= n) {
            return 0;
        }

        // current player can take everything that's left
        if (2 * M >= n - index) {
            return suffix[index];
        }

        // already calculated
        if (memo[index][M] != 0) {
            return memo[index][M];
        }

        int best = 0;

        for (int X = 1; X <= 2 * M; X++) {

            int opponentGets = solve(
                piles,
                index + X,
                Math.max(M, X),
                suffix,
                memo
            );

            int currentPlayerGets = suffix[index] - opponentGets;

            best = Math.max(best, currentPlayerGets);
        }

        memo[index][M] = best;
        return best;
    }
}
