
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> lst = new ArrayList<>();
        
        int j = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                lst.add(arr[i]);
            }
        }
        
        
        Collections.sort(lst);

        
        
        answer = new int[lst.size()];
        
        if(answer.length == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        
        for(int i = 0 ; i < lst.size(); i++){
            
            answer [i]= lst.get(i);
        }
        
        
        return answer;
    }
}