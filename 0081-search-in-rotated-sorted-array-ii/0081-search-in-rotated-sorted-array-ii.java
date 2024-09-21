class Solution {
    public boolean search(int[] arr, int target) {
        int s=0;
        int e=arr.length-1;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(arr[mid]==target) return true;
            if(arr[s]==arr[mid] && arr[mid]==arr[e])
            {
                s++;
                e--;
                continue;
            }
            
            //left sorted
            if(arr[s]<=arr[mid])
            {
                if(arr[s]<=target && target<=arr[mid])
                {
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }
            
            //right sorted
            if(arr[mid]<=arr[e])
            {
                if(arr[mid]<=target && target<=arr[e])
                {
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }
        }
        return false;
    }
}