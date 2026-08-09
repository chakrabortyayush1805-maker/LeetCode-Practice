class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        int[][] memo = new int[n][n + 1];
        return helper(piles, 0, 1, suffixSum, memo);
    }
    
    private int helper(int[] piles, int i, int M, int[] suffixSum, int[][] memo) {
        int n = piles.length;
        
        // Base case: If remaining piles can all be taken
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }
        
        if (memo[i][M] != 0) {
            return memo[i][M];
        }
        
        int maxStones = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int nextM = Math.max(M, X);
            int opponentStones = helper(piles, i + X, nextM, suffixSum, memo);
            
            // Alice gets current suffix sum minus optimal stones Bob gets
            maxStones = Math.max(maxStones, suffixSum[i] - opponentStones);
        }
        
        memo[i][M] = maxStones;
        return maxStones;
    }
}