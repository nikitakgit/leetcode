class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
               int n = nums.length;
        ArrayList<Integer>[] lis = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lis[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lis[edge[0]].add(edge[1]);
            lis[edge[1]].add(edge[0]);
        }
        ArrayList<Integer> inc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long val = (long) nums[i] ^ k;
            if (val > nums[i]) {
                inc.add(i);
            }
        }
        int sz = inc.size();
        if (sz % 2 == 0) {
            long ans = 0;
            for (int num : nums) {
                ans += num;
            }
            for (Integer i : inc) {
                ans -= nums[i];
                long add = (long) nums[i] ^ k;
                ans += add;
            }
            return ans;
        } else {
            long ans = 0;
            for (int num : nums) {
                ans += (long) num;
            }
            long hue = ans;
            for (Integer i : inc) {
                ans -= nums[i];
                long add = (long) nums[i] ^ k;
                ans += add;
            }
            for (int i = 0; i < sz; i++) {
                long add = (long) nums[inc.get(i)] ^ k;
                long curr_ans = ans - add + nums[inc.get(i)];
                hue = Math.max(hue, curr_ans);
            }
            boolean[] vis = new boolean[n];
            for (int i = 0; i < sz; i++) {
                vis[inc.get(i)] = true;
            }
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    long add = (long) nums[i] ^ k;
                    long curr_ans = ans - nums[i] + add;
                    hue = Math.max(hue, curr_ans);
                }
            }
            return hue;
        }
        
    }
}