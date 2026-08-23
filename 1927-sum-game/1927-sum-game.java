class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumL = 0, sumR = 0;
        int cntL = 0, cntR = 0;

        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                cntL++;
            } else {
                sumL += c - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                cntR++;
            } else {
                sumR += c - '0';
            }
        }

        int diffSum = sumL - sumR;
        int diffCnt = cntR - cntL;

        if (diffCnt % 2 != 0) {
            return true;
        }

        return diffSum != (diffCnt / 2) * 9;
    }
}