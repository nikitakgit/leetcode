class Solution {
    public boolean judgeCircle(String moves) {
        int l=0;
        int r=0;
        int u=0;
        int d=0;
        
        for(char c: moves.toCharArray())
        {
            switch(c){
                case 'U' : u++; break;
                case 'D' : d++; break;
                case 'L' : l++; break;
                case 'R' : r++; break;
            }
        }
        
        return l==r && u==d;
    }
}