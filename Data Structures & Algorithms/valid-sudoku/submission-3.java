
class Solution {
    public boolean isValidSudoku(char[][] board) {

       Set<String> hashSet = new HashSet<>();


       for(int i=0;i<board.length;i++){

            for(int j=0;j<board[i].length;j++){

                var currChar = board[i][j];


                if(currChar == '.')
                    continue;
                

                String row = currChar + "in row" + String.valueOf(i);
                String column = currChar + "in column" + String.valueOf(j);
                String box = currChar + "in box" + String.valueOf(i/3)+","+String.valueOf(j/3);

                if(hashSet.contains(row)||hashSet.contains(column)||hashSet.contains(box)){
                    return false;
                }

                hashSet.add(row);
                hashSet.add(column);
                hashSet.add(box);
            }

       }

       return true;
    }
}