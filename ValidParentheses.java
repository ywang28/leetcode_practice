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
    public boolean isValid2(String s) {
        if(s==null || s.length()==0)  return true;
        int len = s.length();
        Stack<Character> parens = new Stack<Character>();
        for(int i=0; i<len; i++)  {
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{')  {
                parens.push(c);
            }
            // invalid char
            else if(c!=')' && c!= ']' && c!= '}')  {
                return false;
            }
            // no matching left parens left
            else if(parens.isEmpty() || (c==')' && parens.pop()!='(') || (c==']' && parens.pop()!='[') || (c=='}' && parens.pop()!='{'))  {
                return false;
            }
        }
        // extra left parens left
        if(!parens.isEmpty())  return false;
        return true;
    }
}
