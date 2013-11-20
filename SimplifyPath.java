import java.util.*;
public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path==null || path.length()==0)  return path;
        LinkedList<Character> pathList = new LinkedList<Character>();
        pathList.push('/');
        for(int i=0; i<path.length(); i++)  {
            if(path.charAt(i) == '/')  {
                if(pathList.isEmpty())  {
                    pathList.push('/');
                }
                // "./" found. remove "." from stack
                else if(pathList.peek() == '.')  {
                    pathList.pop();
                }
                // ignore repetitive '/'
                else if(pathList.peek() != '/')  {
                    pathList.push('/');
                }
            }
            else if(path.charAt(i) == '.')  {
                // "../" found. remove "<DIR>/." from stack
                if(pathList.peek() == '.')  {
                    pathList.pop();
                    pathList.pop();
                    while(!pathList.isEmpty() && pathList.peek() != '/')  {
                        pathList.pop();
                    }
                }
                else  {
                    pathList.push('.');
                }
            }
            // keep saving dir names
            else  {
                pathList.push(path.charAt(i));
            }
        }
        // root dir if empty stack
        if(pathList.isEmpty())  return "/";
        // remove trailing "."
        if(pathList.peek() == '.')  pathList.pop();
        // remove trailing "/"
        if(pathList.peek() == '/' && pathList.size()>1)  pathList.pop();
        StringBuilder ans = new StringBuilder();
        for(char c : pathList)  {
            ans.insert(0, c);
        }
        return ans.toString();
    }
    public static void main(String[] Args)  {
        SimplifyPath s = new SimplifyPath();
        if(Args.length != 1)  {
            System.out.println("One arg expected!");
            System.exit(1);
        }
        System.out.println("Test in: " + Args[0]);
        System.out.println("Test out: " + s.simplifyPath(Args[0]));
    }
}
