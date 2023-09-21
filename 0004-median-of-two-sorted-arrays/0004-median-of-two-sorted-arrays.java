class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] numRes=mergedArray(nums1,nums2);
        double ans=0;
        if (numRes.length%2!=0){
            ans=numRes[numRes.length/2];
        }
        else ans=(numRes[numRes.length/2]+numRes[(numRes.length/2)-1])/2.0;

        return ans;
    }
    public int[] mergedArray(int[] arr1,int[] arr2){
        int[] merged=new int[arr1.length+arr2.length];
        int i=0;
        int j=0;
        int k=0;
        while (i<arr1.length && j<arr2.length){
            if (arr1[i]<=arr2[j]){
               merged[k]=arr1[i];
                i++;
            }else {
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i<arr1.length){
            merged[k]=arr1[i];
            i++;
            k++;
        }
        while (j<arr2.length){
            merged[k]=arr2[j];
            j++;
            k++;
        }
        return merged;
    }
}