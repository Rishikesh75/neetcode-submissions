
class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for(int row = 0; row < 9; row++) {

            for(int col = 0; col < 9; col++) {

                char current = board[row][col];

                // skip empty cells
                if(current == '.') {
                    continue;
                }

                String rowKey = current + " in row " + row;
                String colKey = current + " in col " + col;
                String boxKey = current + " in box " + (row / 3) + "-" + (col / 3);

                // if already exists -> invalid
                if(set.contains(rowKey) ||
                   set.contains(colKey) ||
                   set.contains(boxKey)) {

                    return false;
                }

                // add entries
                set.add(rowKey);
                set.add(colKey);
                set.add(boxKey);
            }
        }

        return true;
    }
}