// pass
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> ret = new ArrayList<String>();
        if(words==null || words.length==0 || L<1)  {
            ret.add("");
            return ret;
        }
        int startIndex = 0, endIndex = 0, len = words.length, charCnt;
        while(startIndex < len)  {
            // first word char count
            charCnt = words[startIndex].length();
            // find ending point for each line
            while(endIndex < len-1 && charCnt <= L)  {
                // consider one space in between
                charCnt += (words[endIndex+1].length()+1);
                endIndex++;
            }
            // last line
            if((endIndex == len-1 && charCnt<=L))  {
                leftJustify(words, startIndex, endIndex, L, charCnt, ret);
                return ret;
            }
            else  {
                // center justify with one word rolled back. charCnt needs to remove one space back too
                centerJustify(words, startIndex, endIndex-1, L, charCnt-words[endIndex].length()-1, ret);
                // get next start index
                startIndex = endIndex;
            }
        }
        return ret;
    }
    public void leftJustify(String[] words, int i, int j, int L, int cnt, ArrayList<String> ret)  {
        StringBuilder sb = new StringBuilder();
        for(int k=i; k<j; k++)  {
            sb.append(words[k]).append(" ");
        }
        sb.append(words[j]);
        // trailing spaces
        while(sb.length()<L)  {
            sb.append(" ");
        }
        ret.add(sb.toString());
    }
    public void centerJustify(String[] words, int i, int j, int L, int cnt, ArrayList<String> ret)  {
        StringBuilder sb = new StringBuilder();
        // only one word
        if(i==j)  {
            sb.append(words[i]);
            while(sb.length()<L)  {
                sb.append(" ");
            }
            ret.add(sb.toString());
            return;
        }
        int extraSpaces = L-cnt;
        StringBuilder basicSpaces = new StringBuilder();
        basicSpaces.append(" ");
        for(int m=0; m<extraSpaces/(j-i); m++)  {
            basicSpaces.append(" ");
        }
        int indexForOneMoreSpace = extraSpaces%(j-i);
        for(int k=i; k<j; k++)  {
            sb.append(words[k]).append(basicSpaces);
            // one more extra space for left side words
            if((k-i)<indexForOneMoreSpace)  {
                sb.append(" ");
            }
        }
        // last word
        sb.append(words[j]);
        ret.add(sb.toString());
    }
}
