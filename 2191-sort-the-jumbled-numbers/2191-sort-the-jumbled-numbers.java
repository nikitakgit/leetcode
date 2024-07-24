class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        Integer[] numsArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsArray[i] = nums[i];
        }
         Arrays.sort(numsArray, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int mappedA = convert(a, mapping);
                int mappedB = convert(b, mapping);
                return Integer.compare(mappedA, mappedB);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsArray[i];
        }

        return nums;
        
    }
    private int convert(int n, int[] mapping) {
        String num = Integer.toString(n);
        StringBuilder val = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            val.append(mapping[num.charAt(i) - '0']);
        }
        return Integer.parseInt(val.toString());
    }
}