class Solution {
    public void swap(int[] arr,int start,int end){
        if(arr.length>1)
        {
            while(start<=end)
            {
               int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
    }
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        swap(nums,0,nums.length-k-1);
        swap(nums,nums.length-k,nums.length-1);
        swap(nums,0,nums.length-1);
    }
}