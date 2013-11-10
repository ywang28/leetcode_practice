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
}
