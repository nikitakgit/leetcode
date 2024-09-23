class Solution {
    class TrieNode {
        TrieNode[] child;
        boolean isEnd;

        TrieNode() {
            child = new TrieNode[26];
            for (int i = 0; i < 26; i++)
                child[i] = null;
            isEnd = false;
        }
    }

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); ++i) {
                int idx = word.charAt(i) - 'a';
                if (curr.child[idx] == null)
                    curr.child[idx] = new TrieNode();
                curr = curr.child[idx];
            }
            curr.isEnd = true;
        }
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            ArrayList<Integer> temp = new ArrayList<>();
            TrieNode node = root;
            int j = i;
            while (j < n) {
                int idx = s.charAt(j) - 'a';
                if (node.child[idx] == null)
                    break;
                node = node.child[idx];
                if (node.isEnd)
                    temp.add(j);
                j++;
            }
            dp[i] = 1 + dp[i + 1];
            for (int x : temp)
                dp[i] = Math.min(dp[i], dp[x + 1]);
        }
        return dp[0];
    }
}