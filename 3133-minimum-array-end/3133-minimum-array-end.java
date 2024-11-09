class Solution {
    public long minEnd(int n, int x) {
        long num = x;

        for(int i = 1; i < n; i++) {

            // one line is enough (whole thinking)
            num = (num+1) | x;
            
        }

        return num;
    }
}