class Solution {
    public String reverseVowels(String s) {
       char[] arr=s.toCharArray();
        int start=0;
        int end=s.length()-1;
        String vowel="aeiouAEIOU";
        while(start<end)
        {
            while(start<end && vowel.indexOf(arr[start])==-1)
            {
                start++;
            }
            while(start<end && vowel.indexOf(arr[end])==-1)
            {
                end--;
            }
            
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            
            start++;
            end--;
        }
        String ans=new String(arr);
        return ans;
    }
}