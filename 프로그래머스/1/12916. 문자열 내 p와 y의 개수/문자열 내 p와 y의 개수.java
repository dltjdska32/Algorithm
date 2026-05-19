import java.lang.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        String[] str = s.toLowerCase().split("");
        
        int c = 0;
        
        for(int i = 0; i < str.length; i++){
            
            if (str[i].equals("p")){
                c++;
            } else if (str[i].equals("y")){
                c--;
            }
            
        }
        
                       
                if (c != 0){
                answer = false;
                }

        return answer;
    }
}