class Solution {
    public String removeDuplicateLetters(String s) {
        
       HashMap<Character, Integer> inStack = new HashMap<>();
       HashMap<Character, Integer> freq = new HashMap<>();

       Stack<Character> st = new Stack<>();
       for(int i=0;i<s.length();i++)
       {
           char ch = s.charAt(i);
           freq.put(ch, freq.getOrDefault(ch,0)+1);
       }

       for(int i=0;i<s.length();i++)
       {
           char ch = s.charAt(i);
           if(inStack.containsKey(ch)==true)
           {
               freq.put(ch, freq.getOrDefault(ch,0)-1);
               continue;
           }

           while(st.size()>0 && st.peek()>ch && freq.get(st.peek())>=1)
           {
               inStack.remove(st.peek());
               st.pop();
           }

           st.push(ch);
           inStack.put(ch, 1);
           freq.put(ch, freq.getOrDefault(ch,0)-1);
       }

       StringBuilder ans= new StringBuilder();
       while(st.size()>0)
       {
           ans.insert(0,st.pop());
       }

       return ans.toString();
    }
}