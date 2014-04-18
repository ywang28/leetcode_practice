public class GenerateParenthesis {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        if(n<1)  {
            ans.add("");
            return ans;
        }
        genParen(n, 0, 0, new ArrayList<Character>(), ans);
        return ans;
    }
    public void genParen(int n, int left, int right, ArrayList<Character> parens, ArrayList<String> ans)  {
        // valid parens generated
        if(left==n && right==n)  {
            StringBuilder sb = new StringBuilder(n*2);
            for(Character c : parens)  {
                sb.append(c);
            }
            ans.add(sb.toString());
        }
        // DFS algorithm. add as many as left parens as possible first
        if(left<n)  {
            parens.add('(');
            genParen(n, left+1, right, parens, ans);
            parens.remove(parens.size()-1);
        }
        if(right<left)  {
            parens.add(')');
            genParen(n, left, right+1, parens, ans);
            parens.remove(parens.size()-1);
        }
    }
    public ArrayList<String> generateParenthesis2(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        if(n < 1)  return ret;
        parenHelper(n, n, ret, new StringBuilder());
        return ret;
    }
    public void parenHelper(int left, int right, ArrayList<String> ret, StringBuilder path)  {
        // no parens left
        if(left==0 && right==0)  {
            ret.add(new String(path));
            return;
        }
        // DFS
        if(left>0)  {
            path.append('(');
            parenHelper(left-1, right, ret, path);
            path.setLength(path.length()-1);
            // valid ')' can be added
            if(right > left)  {
                path.append(')');
                parenHelper(left, right-1, ret, path);
                path.setLength(path.length()-1);
            }
        }
        else {
            path.append(')');
            parenHelper(left, right-1, ret, path);
            path.setLength(path.length()-1);
        }
    }
}
