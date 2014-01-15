public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(board==null || board.length!=9 || board[0].length!=9)  return;
        // record if num exist in ith row/col/block
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blks = new boolean[9][9];
        // initialize boolean table
        for(int i=0; i<9; i++)  {
            for(int j=0; j<9; j++)  {
                if(board[i][j] == '.')  continue;
                // invalid char found
                if(board[i][j] < '1' || board[i][j] > '9')  return;
                int num = board[i][j] - '1';
                // invalid sudoku
                if(rows[i][num] == true || cols[j][num] == true || blks[3*(i/3) + (j/3)][num] == true)   return;
                rows[i][num] = true;
                cols[j][num] = true;
                blks[3*(i/3) + (j/3)][num] = true;
            }
        }
        // solve sudoku
        fillSudoku(board, rows, cols, blks, 0, 0);
    }
    public boolean fillSudoku(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] blks, int x, int y)  {
        // filled last space
        if(x==8 && y==9)  return true;
        // begin new row
        if(y==9)  {
            y = 0;
            x++;
        }
        // if current is filled, continue fill next
        if(board[x][y] != '.')  return fillSudoku(board, rows, cols, blks, x, y+1);
        ArrayList<Character> candidates = new ArrayList<Character>();
        // find candidate chars for current spot
        for(char c='1'; c<='9'; c++)  {
            int i = c - '1';
            if(!rows[x][i] && !cols[y][i] && !blks[3*(x/3)+(y/3)][i])  candidates.add(c);
        }
        // DFS search
        for(char c : candidates)  {
            board[x][y] = c;
            int num = c - '1';
            rows[x][num] = true;
            cols[y][num] = true;
            blks[3*(x/3) + (y/3)][num] = true;
            // one of number is correct
            if(fillSudoku(board, rows, cols, blks, x, y+1))  return true;
            // change back status
            board[x][y] = '.';
            rows[x][num] = false;
            cols[y][num] = false;
            blks[3*(x/3) + (y/3)][num] = false;
        }
        return false;
    }
}
