class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int firstIndex = 0; 
        int lastIndex = 0;

        int i = 0; 
        while (i < s.length()) {
            if(str[i] == ' ') {
                i++;
            } else {
                if(i == 0 || str[i-1] == ' ') {
                    firstIndex = i;
                }

                if(i == s.length() - 1 || str[i+1] == ' ') {
                    lastIndex = i;
                }

                if((firstIndex == 0 || str[firstIndex - 1] == ' ') && 
                (lastIndex == s.length() - 1 || str[lastIndex + 1] == ' ')) {
                    while(firstIndex <= lastIndex) {
                        char temp = str[firstIndex];
                        str[firstIndex] = str[lastIndex];
                        str[lastIndex] = temp;

                        firstIndex++;
                        lastIndex--;
                    }
                }
                i++;
            }
        }

        return s.valueOf(str);
    }
}