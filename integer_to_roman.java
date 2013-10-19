public class Solution {
    public String intToRoman(int num) {
        String[] romanTens = new String[]{"I","X","C","M"};
        String[] romanFives = new String[]{"V","L","D"};
        int base = 1000;
        int digit;
        String romanNum = "";
        for(int i=3; i>=0; i--, base/=10)  {
            digit = num/base;
            num %= base;
            if(digit==0)  continue;
            if(digit==4)  {
                romanNum += romanTens[i] + romanFives[i];
                continue;
            }
            else if(digit==9)  {
                romanNum += romanTens[i] + romanTens[i+1];
                continue;
            }
            else if(digit>=5)  {
                romanNum += romanFives[i];
                digit -= 5;
            }
            // fill with 1-3 basic tens
            for(int j=0; j<digit; j++)  {
                romanNum += romanTens[i];
            }
        }
        return romanNum;
    }
}
