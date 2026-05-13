class Solution {

    public void dfs(int row,int column,boolean[][] visitedArr,char[][] grid){

        if(visitedArr[row][column])
            return;
        
        visitedArr[row][column] = true;

        if(row+1<visitedArr.length && grid[row+1][column] == '1') dfs(row+1,column,visitedArr,grid);

        if(column+1<visitedArr[0].length && grid[row][column+1] == '1') dfs(row,column+1,visitedArr,grid);

        if(row-1>=0 && grid[row-1][column] == '1') dfs(row-1,column,visitedArr,grid);

        if(column-1>=0 && grid[row][column-1] == '1') dfs(row,column-1,visitedArr,grid);


        return;
    }
    public int numIslands(char[][] grid) {
        

        boolean[][] visitedArr = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                  if(!visitedArr[i][j] && grid[i][j] == '1'){
                    dfs(i,j,visitedArr,grid);
                    count++;
                }
            }
              
            
        }

        return count;

    }
}
