class Solution {
    public int hammingWeight(int n) {
        int ans=0;
        String bin=decimalToBinary(n);
        for(int i=0;i<bin.length();i++)
        {
            if(bin.charAt(i)=='1')
            {
                ans++;
            }
        }
        return ans;
    }
    
    
    public String decimalToBinary(int decimal) {
    if (decimal == 0) {
        return "0";
    }
    
    StringBuilder binary = new StringBuilder();
    
    while (decimal > 0) {
        int remainder = decimal % 2;
        binary.insert(0, remainder);
        decimal = decimal / 2;
    }
    
    return binary.toString();
}
}