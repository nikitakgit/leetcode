class Solution {
    public int maximalRectangle(char[][] matrix) {
       if(matrix.length==0) return 0;
        int maxArea=0;
        int[] ht=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='1') ht[j]++;
                else ht[j]=0;
            }
            int area=largestRectangleArea(ht);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights)
    {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        int n=heights.length;
        for(int i=0;i<=n;i++)
        {
            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i]))
            {
                int ht=heights[st.pop()];
                int width;
                if(st.isEmpty())
                {
                    width=i;
                }else{
                    width=i-st.peek()-1;
                }
                maxArea=Math.max(maxArea,width*ht);
            }
            st.push(i);
        }
        return maxArea;
    }
}