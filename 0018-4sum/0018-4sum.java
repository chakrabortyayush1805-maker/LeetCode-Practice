import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return result;

        // Step 1: Sort Array
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate i elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Optimization 1: Smallest sum target se bada hai
            long minSum1 = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minSum1 > target) break;

            // Optimization 2: Largest sum target se chota hai
            long maxSum1 = (long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (maxSum1 < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Optimization 3
                long minSum2 = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minSum2 > target) break;

                // Optimization 4
                long maxSum2 = (long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (maxSum2 < target) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}