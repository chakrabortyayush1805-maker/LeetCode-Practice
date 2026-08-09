import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Array ko sort karo
        Arrays.sort(strs);

        // Pehli aur aakhri string le lo
        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        // Common prefix substring return karo
        return first.substring(0, i);
    }
}