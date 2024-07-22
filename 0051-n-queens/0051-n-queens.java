class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        
        List<List<String>> ans=new ArrayList<>();
        dfs(0,board,ans);
        return ans;
    }
    static void dfs(int col,char[][] board,List<List<String>> ans)
    {
        if(col==board.length)
        {
            ans.add(construct(board));
            return;
        }
        for(int row=0;row<board.length;row++)
        {
                if(isSafe(board,row,col))
                {
                    board[row][col]='Q';
                    dfs(col+1,board,ans);
                    board[row][col]='.';
                }
        }
    }
    static boolean isSafe(char[][] board,int r,int c)
    {
        int dupr=r;
        int dupc=c;
        while(r>=0 && c>=0)
        {
            if(board[r][c]=='Q') return false;
            r--;
            c--;
        }
        
        r=dupr;
        c=dupc;
        
        while(c>=0)
        {
            if(board[r][c]=='Q') return false;
            c--;
        }
        
        r=dupr;
        c=dupc;
        while(c>=0 && r<board.length)
        {
            if(board[r][c]=='Q') return false;
            c--;
            r++;
        }
        return true;
    }
    static List<String> construct(char[][] board)
    {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            String s=new String(board[i]);
            ans.add(s);
        }
        return ans;
    }
}