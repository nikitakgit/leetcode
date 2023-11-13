class Solution {
    public String sortVowels(String s) {
        char[] arr=s.toCharArray();
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Character> a1=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            boolean af=Vowel(arr[i]);
            if(af==true)
            {
                a.add(i);
                a1.add(arr[i]);
            }
        }
        
        
        Collections.sort(a1);
        
        
        for(int i=0;i<a.size();i++)
        {
            arr[a.get(i)]=a1.get(i);
        }
        
        StringBuilder sb = new StringBuilder();
 
        // Creating a string using append() method
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
 
        return sb.toString();
    
        
    }
    public boolean Vowel(char y)
    {
        if (y == 'a' || y == 'e' || y == 'i' || y == 'o'
            || y == 'u' || y == 'A' || y == 'E' || y == 'I'
            || y == 'O' || y == 'U')
            return true;
        else
            return false;
    }
    
}