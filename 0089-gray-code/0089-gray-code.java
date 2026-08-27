import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        int total = 1 << n;
        List<Integer> result = new ArrayList<>(total);

        for (int i = 0; i < total; i++) {
            result.add(i ^ (i >> 1));
        }

        return result;
    }
}