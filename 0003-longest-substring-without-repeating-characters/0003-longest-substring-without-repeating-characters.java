class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int[] lastSeen = new int[128]; 
        
        java.util.Arrays.fill(lastSeen, -1);

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastSeen[c] >= left) {
                left = lastSeen[c] + 1;
            }

            lastSeen[c] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}