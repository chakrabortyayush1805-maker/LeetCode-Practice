import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        row.add(1);

        long val = 1;
        for (int j = 1; j <= rowIndex; j++) {
            val = val * (rowIndex - j + 1) / j;
            row.add((int) val);
        }

        return row;
    }
}