public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0)  return 0;
        if(tokens.length==1)  return Integer.parseInt(tokens[0]);
        Stack<Integer> calc = new Stack<Integer>();
        calc.push(Integer.parseInt(tokens[0]));
        calc.push(Integer.parseInt(tokens[1]));
        for(int i=2; i<tokens.length; i++)  {
            if(Character.isDigit(tokens[i].charAt(tokens[i].length()-1)))  {
                calc.push(Integer.parseInt(tokens[i]));
            }
            else  {
                int oper2 = calc.pop();
                int oper1 = calc.pop();
                if(tokens[i].equals("+"))  {
                    calc.push(oper1 + oper2);
                }
                else if(tokens[i].equals("-"))  {
                    calc.push(oper1 - oper2);
                }
                else if(tokens[i].equals("*"))  {
                    calc.push(oper1 * oper2);
                }
                else  {
                    calc.push(oper1 / oper2);
                }
            }
        }
        return calc.pop();
    }
}
