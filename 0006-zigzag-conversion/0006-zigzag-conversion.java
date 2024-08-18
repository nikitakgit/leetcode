class Solution {
    public String convert(String s, int numRows) {
      char[] arr =s.toCharArray();
      int n = arr.length;
      StringBuffer[] sb = new StringBuffer[numRows];
      for(int i=0;i<numRows;i++){
          sb[i]=new StringBuffer();
      }  
      int i=0;
      while(i<n){
          for(int idx=0;idx<numRows && i<n;idx++){
              sb[idx].append(arr[i++]);
          }
          for(int idx=numRows-2;idx>=1 && i<n;idx--){
              sb[idx].append(arr[i++]);
          }
      }
      for(int j=1;j<sb.length;j++){
          sb[0].append(sb[j]);
      }
      return sb[0].toString();
    }
}
