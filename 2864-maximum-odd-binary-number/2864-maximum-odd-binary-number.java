class Solution {
    public String maximumOddBinaryNumber(String s) {
        int oneCount = frequency(s, '1');
        int size = s.length();
        int zeroCount = size - oneCount;
        StringBuilder res = new StringBuilder();
        
        oneCount--; // decrementing oneCount as we will append one more '1' at the end
        while (oneCount-- > 0) {
            res.append('1');
        }
        while (zeroCount-- > 0) {
            res.append('0');
        }
        res.append('1');
        
        return res.toString();
    }
    private int frequency(String s, char pat){
        int count = 0;
        for(var chr : s.toCharArray()){
            if(chr == pat){
                count++;
            }
        }
        return count++;
    }
}