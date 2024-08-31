class Solution {
    class Pair {
        int index;
        int val;
        Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public long subArrayRanges(int[] A) {
        int n = A.length;
        long res = 0;
        long a=sumSubarrayMaxs(A);
        long b = sumSubarrayMins(A);

        res = a-b;
        return res;
    }
    public long sumSubarrayMaxs(int[] A){
        
        Stack<Pair> s = new Stack<>();
        long a=0;
        int n = A.length;

        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && (i == n || s.peek().val < A[i])) {
                Pair p = s.pop();
                int m = p.val;
                int j = p.index;
                int k = s.isEmpty() ? -1 : s.peek().index;
                int left = j - k;
                int right = i - j;
                a += (long) m * left * right;
            }
            if (i < n) s.push(new Pair(i, A[i]));
        }
        return a;        
    }
    
    public long sumSubarrayMins(int[] A) {
        
        int n = A.length;
        long res = 0;

        
        Stack<Pair> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && (i == n || A[s.peek().index] > A[i])) {
                Pair p = s.pop();
                int m = p.val;
                int j = p.index;
                int k = s.isEmpty() ? -1 : s.peek().index;
                int left = j - k;
                int right = i - j;
                res = (res + (long) m * left * right);
            }
            if (i < n) s.push(new Pair(i,A[i]));
        }

        return res;
    }
}