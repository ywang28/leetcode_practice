public class ValidParentheses {
    public boolean isValid(String s) {
        if(s==null || s.length()==0)    return true;
        // if odd number of parens
        if(s.length()%2!=0)   return false;
        LinkedList<Character> openParen = new LinkedList<Character>();
        for(int i=0; i<s.length(); i++)  {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')  {
                openParen.push(s.charAt(i));
            }
            else if(s.charAt(i)==')')  {
                if (openParen.isEmpty() || openParen.pop()!='(')
                    return false;
            }
            else if(s.charAt(i)==']')  {
                if (openParen.isEmpty() || openParen.pop()!='[')
                    return false;
            }
            else  {
                if (openParen.isEmpty() || openParen.pop()!='{')
                    return false;
            }
        }
        return openParen.isEmpty();
    }
}
