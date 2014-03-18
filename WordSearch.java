// pass
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0 || word==null || word.length()==0)  return false;
        for(int i=0; i<board.length; i++)  {
            for(int j=0; j<board[0].length; j++)  {
                if(existHelper(board, i, j, word, 0))  return true;
            }
        }
        return false;
    }
    public boolean existHelper(char[][] board, int m, int n, String word, int index)  {
        // valid word found
        if(index == word.length())  return true;
        // if out of boudary or not matching with current, false
        if(m<0 || m>board.length-1 || n<0 || n>board[0].length-1 || word.charAt(index)!=board[m][n])  return false;
        // mark current node as used
        board[m][n] = '#';
        if(existHelper(board, m-1, n, word, index+1) || existHelper(board, m+1, n, word, index+1) 
            || existHelper(board, m, n-1, word, index+1) || existHelper(board, m, n+1, word, index+1))  return true;
        // restore current char
        board[m][n] = word.charAt(index);
        return false;
    }
}
