class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(char x:s.toCharArray())
        {
            sb.append(x-'a'+1);
        }
        while(k>0)
        {
            int temp=0;
            for(char x:sb.toString().toCharArray())
            {
                temp+=x-'0';
            }
            sb=new StringBuilder(String.valueOf(temp));
            k--;
        }
        return Integer.parseInt(sb.toString());
    }
}

 