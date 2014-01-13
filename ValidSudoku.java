public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(board==null || board.length!=9 || board[0].length!=9)  return false;
        HashMap<Character,Boolean> map = new HashMap<Character,Boolean>();
        // Initialize hash map
        for(char c='1'; c<='9'; c++)  {
            map.put(c,false);
        }
        // Check each row or col
        for(int i=0; i<9; i++)  {
            HashMap<Character,Boolean> mapX = new HashMap<Character,Boolean>(map);
            HashMap<Character,Boolean> mapY = new HashMap<Character,Boolean>(map);
            for(int j=0; j<9; j++)  {
                if(board[i][j] != '.')  {
                    // repeated char found
                    if(mapX.get(board[i][j]) == true)  return false;
                    mapX.put(board[i][j],true);
                }
                if(board[j][i] != '.')  {
                    if(mapY.get(board[j][i]) == true)  return false;
                    mapY.put(board[j][i],true);
                }
            }
        }
        
        // check subboxes. board[i][j] is starting point
        for(int i=0; i<7; i+=3)  {
            for(int j=0; j<7; j+=3)  {
                // Any of subbox is invalid
                if(!checkSubbox(new HashMap<Character,Boolean>(map), board, i, j))  return false;
            }
        }
        return true;
    }
    public boolean checkSubbox(HashMap<Character,Boolean> map, char[][] board, int x, int y)  {
        for(int i=x; i<x+3; i++)  {
            for(int j=y; j<y+3; j++)  {
                if(board[i][j] != '.')  {
                    // repeated char found
                    if(map.get(board[i][j]) == true)  return false;
                    map.put(board[i][j],true);
                }
            }
        }
        return true;
    }
}
