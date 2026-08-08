class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] last = new int[m + 1];
        last[m] = n;

        // Step 1: Pre-calculate rightmost valid positions for suffix matching
        int p = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }
            last[j] = p;
            if (p >= 0) p--;
        }

        int[] res = new int[m];
        boolean changed = false;
        int i = 0;

        // Step 2: Build sequence
        for (int j = 0; j < m; j++) {
            boolean matched = false;
            while (i < n) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    res[j] = i;
                    i++;
                    matched = true;
                    break;
                } else if (!changed && last[j + 1] > i) {
                    changed = true;
                    res[j] = i;
                    i++;
                    matched = true;
                    break;
                }
                i++;
            }
            if (!matched) return new int[0];
        }

        return res;
    }
}