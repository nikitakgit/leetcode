class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0,rsum=0;
        int maxScore=0;
        int n=cardPoints.length;
        for(int i=0;i<k;i++)
        {
            lsum+=cardPoints[i];
        }
        maxScore=lsum;
        int r=n-1;
        for(int i=k-1;i>=0;i--)
        {
            lsum-=cardPoints[i];
            rsum+=cardPoints[r];
            r--;
            int sum=lsum+rsum;
            maxScore=Math.max(maxScore,sum);
        }
        return maxScore;
    }
}
