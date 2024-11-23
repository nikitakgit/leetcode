class Solution {
    public char[][] rotateTheBox(char[][] box) {
      int row=box.length,col=box[0].length;
        char[][] rBox=new char[col][row];
        
        // Simulate gravity
        for (int i = 0; i < row; i++) {
            int cell = col - 1;
            for (int j = col - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    cell = j - 1;
                } else if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][cell--] = '#';
                }
            }
        }
        
        //rotate box by 90 degree
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                rBox[j][row-i-1]=box[i][j];
            }
        }
        return rBox;
    }
}
 