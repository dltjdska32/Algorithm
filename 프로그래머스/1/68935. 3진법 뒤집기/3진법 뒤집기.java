import java.util.*;
import java.lang.*;
import java.math.*;


class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<Integer> al = new ArrayList<Integer>();
        
        int tmp = n;
        while (true) {
            
            int rm = tmp % 3;
            al.add(rm);
            
            tmp /= 3;
            
        
            
            if(tmp  == 0){
             break;
            }
            
        }
        
        System.out.println(al);
        
        int num = 0;
        for(int i = al.size() - 1; i >= 0 ; i--){
            
            
           int k =  al.get(i);
            if(k != 0){ 
                
                System.out.println(k+ " " + num + " " +  Math.pow(3, num));
                
                answer += k *Math.pow(3, num) ;
             
            }
            num ++ ;   
        }
        
        
        return answer;
    }
}