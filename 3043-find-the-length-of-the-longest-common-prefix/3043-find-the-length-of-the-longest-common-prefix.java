class TrieNode {
    TrieNode[] children;
    int count;

    public TrieNode() {
        children = new TrieNode[10];
        count = 0;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            int index = ch - '0';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.count++;
        }
    }

    public int findCommonPrefixLength(String str) {
        TrieNode node = root;
        int commonPrefixLength = 0;

        for (char ch : str.toCharArray()) {
            int index = ch - '0';
            if (node.children[index] != null && node.children[index].count > 0) {
                node = node.children[index];
                commonPrefixLength++;
            } else {
                break;
            }
        }

        return commonPrefixLength;
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();

        for (int y : arr2) {
            trie.insert(String.valueOf(y));
        }

        int maxCommonPrefixLength = 0;

        for (int x : arr1) {
            String strX = String.valueOf(x);
            int commonPrefixLength = trie.findCommonPrefixLength(strX);
            maxCommonPrefixLength = Math.max(maxCommonPrefixLength, commonPrefixLength);
        }

        return maxCommonPrefixLength;
    }
}