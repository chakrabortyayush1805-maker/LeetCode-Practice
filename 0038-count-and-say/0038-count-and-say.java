class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int len = result.length();
            int j = 0;

            while (j < len) {
                char ch = result.charAt(j);
                int count = 0;

                while (j < len && result.charAt(j) == ch) {
                    count++;
                    j++;
                }

                sb.append(count).append(ch);
            }

            result = sb.toString();
        }

        return result;
    }
}