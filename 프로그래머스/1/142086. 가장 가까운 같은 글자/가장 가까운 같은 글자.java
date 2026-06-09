import java.util.*;
import java.lang.*;


class Solution {
    public int[] solution(String s) {
        Map<String, Integer> m = new HashMap<>();
        
        int[] answer = new int[s.length()];
        
        String[] str = s.split("");
        
        
        for(int i = 0; i< str.length; i++){
            
            if(!m.containsKey(str[i])){
                answer[i] = -1;
                m.put(str[i], i);
            } else {
                int tmp = i - m.get(str[i]);
                m.put(str[i], i);
                answer[i] = tmp;
            }
        }
        
        return answer;
    }
}