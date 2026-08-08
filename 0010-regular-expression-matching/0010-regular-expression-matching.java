class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] stores whether s[i...] matches p[j...]
        Boolean[][] memo = new Boolean[m + 1][n + 1];
        return dp(0, 0, s, p, memo);
    }
    
    private boolean dp(int i, int j, String s, String p, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        boolean ans;
        if (j == p.length()) {
            ans = (i == s.length());
        } else {
            boolean firstMatch = (i < s.length() && 
                                 (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
            
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                // Choice 1: Skip the '*' and preceding character (0 occurrences)
                // Choice 2: Use '*' if firstMatch is true (1 or more occurrences)
                ans = dp(i, j + 2, s, p, memo) || 
                      (firstMatch && dp(i + 1, j, s, p, memo));
            } else {
                ans = firstMatch && dp(i + 1, j + 1, s, p, memo);
            }
        }
        
        memo[i][j] = ans;
        return ans;
    }
}