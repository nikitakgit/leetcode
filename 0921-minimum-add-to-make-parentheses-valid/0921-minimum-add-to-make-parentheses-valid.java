class Solution {
    public int minAddToMakeValid(String s) {
        int openReq = 0;
       int openCnt = 0;
       for(var chr : s.toCharArray()){
        if(chr == '(')openCnt++;
        else{
            if(openCnt > 0)openCnt--;
            else openReq++;
        }
       }
       int closeReq = openCnt;
       return openReq + closeReq;
    }
}