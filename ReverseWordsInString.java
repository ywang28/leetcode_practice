public class ReverseWordsInString {
    public String reverseWords(String s) {
        if(s==null || s.length()==0)  return "";
        s.trim();
        String[] words = s.split(" +");
        if(words.length==0)  return "";
        for(int i=0; i<words.length/2; i++)  {
            String tmp = words[i];
            words[i] = words[words.length-1-i];
            words[words.length-1-i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length; i++)  {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
