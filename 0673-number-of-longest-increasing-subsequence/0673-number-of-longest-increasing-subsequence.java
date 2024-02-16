class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n]; 
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxi = 1; 

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j]+1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if ( nums[i]>nums[j] && dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        int numbers = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) {
                numbers += count[i];
            }
        }

        return numbers;
        
    }
}
