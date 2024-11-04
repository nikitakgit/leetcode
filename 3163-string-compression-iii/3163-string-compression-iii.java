class Solution {
    public String compressedString(String word) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        int n=word.length();

        while(i<n)
        {
            char c=word.charAt(i);
            int cnt=0;
            while(i<n && word.charAt(i)==c && cnt<9)
            {
                cnt++;
                i++;
            }
            sb.append(cnt).append(c);
        }
        return sb.toString();
    }
}