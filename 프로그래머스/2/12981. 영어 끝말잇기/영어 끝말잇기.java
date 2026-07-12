import java.util.*;
import java.lang.*;


class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        
        int turn = 1;
        
        Set<String> check = new HashSet<>();
        
        int curNum = 1;
        
        for(int i = 0; i < words.length; i++){
            
            String w = words[i];
            
            if(check.contains(w)){
                answer[0] = curNum;
                answer[1] = turn;
                break;
            }
            
            if(i > 0) {
                
                int l = words[i - 1].length() - 1;
                
                String s = w.split("")[0];
                String cs = words[i - 1].split("")[l];
                
                if(!s.equals(cs)){
                    answer[0] = curNum;
                    answer[1] = turn;
                    break;
                }
            }
            
            check.add(w);
            
            
            if((i + 1) % n == 0){
                turn++;
                curNum = 1;
                continue;
            }
            
            curNum++;
        }

        return answer;
    }
}