class Solution {
    public String largestOddNumber(String num) {
        String charToString=String.valueOf(num.charAt(num.length()-1));
        int stringToInt=Integer.parseInt(charToString);
        if(stringToInt%2!=0)
        {
            return num;
        }
        String ans="";
        for(int i=num.length()-1;i>=0;i--)
        {
            String temp=String.valueOf(num.charAt(i));
            int intTemp=Integer.parseInt(temp);
            if(intTemp%2!=0)
            {
                ans+=num.substring(0,i+1);
                return ans;
            }
        }
        return ans;
    }
}

 