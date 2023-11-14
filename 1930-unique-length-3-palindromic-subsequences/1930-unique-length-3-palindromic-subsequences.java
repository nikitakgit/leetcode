class Solution {
    public int countPalindromicSubsequence(String s) {
        int firstIndex[] = new int[26], lastIndex[] = new int[26], result = 0;
        Arrays.fill(firstIndex, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); ++i) {
            firstIndex[s.charAt(i) - 'a'] = Math.min(firstIndex[s.charAt(i) - 'a'], i);
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; ++i)
            if (firstIndex[i] < lastIndex[i])
                result += s.substring(firstIndex[i] + 1, lastIndex[i]).chars().distinct().count();
        return result;
    }
}