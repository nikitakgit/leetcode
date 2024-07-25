class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public void merge(int[] nums,int l,int m,int r)
    {
        int n1=m-l+1;
        int n2=r-m;
        
        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=0;i<n1;i++)
        {
            L[i]=nums[l+i];
        }
        for(int i=0;i<n2;i++)
        {
            R[i]=nums[m+1+i];
        }
        
         int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            }
            else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
        
        
    }
    public void mergeSort(int[] nums,int low,int high)
    {
        
        if(low<high)
        {
            int mid=low+(high-low)/2;
            mergeSort(nums,low,mid);
            mergeSort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
    }
}