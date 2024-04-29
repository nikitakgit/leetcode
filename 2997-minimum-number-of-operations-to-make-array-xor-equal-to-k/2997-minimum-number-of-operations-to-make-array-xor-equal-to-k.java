class Solution {
    public int minOperations(int[] v, int k) {
        int n = v.length;
        int ans = 0;
        for (int i = 0; i <= 30; i++) {
            int b = 0;
            for (int j = 0; j < n; j++) {
                if (((v[j] >> i) & 1) == 1)
                    b = b ^ 1;
            }
            if (((k >> i) & 1) != b)
                ans++;
        }
        return ans;
    }
}