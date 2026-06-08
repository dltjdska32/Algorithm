/// 아스키 A, Z,  a , z , -> 65 90 97 122
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] c = s.toCharArray();
        
        for(int i = 0; i < c.length; i++){
            
            char getC = c[i];
            
        
            
            if (getC == ' ') {
                answer += " ";
                continue;
            }
            
            
            if( getC >= 'a' && getC <= 'z'){
                
                char tmpC = (char) (getC + n);
                
                if(tmpC > 'z'){
                    tmpC = (char) (tmpC - 26);
                }
                
                answer += tmpC;
            } else if(getC >= 'A' && getC <= 'Z') {
                
                char tmpC = (char) (getC + n);
                
                if(tmpC > 'Z'){
                    tmpC = (char) (tmpC - 26);
                }
                
                answer += tmpC;
            }
            
        }
        
        return answer;
    }
}