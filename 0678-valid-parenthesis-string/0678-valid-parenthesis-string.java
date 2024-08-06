class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        // dp[i][cnt] indicates whether the string from index i to n can be valid with cnt '(' minus ')'
        Boolean[][] dp = new Boolean[n + 1][n + 1];
        return helper(s, 0, 0, dp);
    }

    private boolean helper(String s, int i, int cnt, Boolean[][] dp) {
        if (cnt < 0) return false; // More closing brackets than opening ones
        if (i == s.length()) {
            return cnt == 0; // All opening brackets should be matched with closing brackets
        }
        if (dp[i][cnt] != null) {
            return dp[i][cnt];
        }

        boolean result;
        if (s.charAt(i) == '(') {
            result = helper(s, i + 1, cnt + 1, dp);
        } else if (s.charAt(i) == ')') {
            result = helper(s, i + 1, cnt - 1, dp);
        } else { // s.charAt(i) == '*'
            result = helper(s, i + 1, cnt + 1, dp) || helper(s, i + 1, cnt, dp) || helper(s, i + 1, cnt - 1, dp);
        }

        dp[i][cnt] = result;
        return result;
    }
}