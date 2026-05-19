import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        List<Integer> a = new ArrayList<>();
        
        for(int i = 0; i < 10; i++){
            a.add(i);
            answer += i;
        }
        
        
        for(int i = 0; i< a.size(); i++){

            for(int j = 0; j < numbers.length; j++){
                
                if(a.get(i) == numbers[j]){
                    answer -= numbers[j];
                }
            }
        }
        
      
     
        return answer;
    }
}