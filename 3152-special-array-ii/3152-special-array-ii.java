class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] ans = new boolean[queries.length];
        
        // Preprocess to find parity change points
        boolean[] parityChange = new boolean[n];
        for (int i = 1; i < n; i++) {
            parityChange[i] = (nums[i] % 2 != nums[i - 1] % 2);
        }

        // Prefix sum array to count parity changes
        int[] prefixParityChanges = new int[n];
        for (int i = 1; i < n; i++) {
            prefixParityChanges[i] = prefixParityChanges[i - 1] + (parityChange[i] ? 1 : 0);
        }

        // Answer each query using the prefix sum array
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = (prefixParityChanges[right] - prefixParityChanges[left]) == (right - left);
        }

        return ans;
    }
}
