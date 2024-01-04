class Solution {
    public int minOperations(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
    
    for (int i : nums) {
        map.put(i, map.getOrDefault(i, 0) + 1);
    }
    
    int c = 0;
    
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int n = entry.getValue();
        
        if(n==1)
        {
            return -1;
        }
        
        if (n % 3 == 1) {
            c += (n - 1) / 3 + 1;
        } else if (n % 3 == 2) {
            c += (n - 2) / 3 + 1;
        } else {
            c += n / 3;
        }
    }
    
    return c;
    }
}