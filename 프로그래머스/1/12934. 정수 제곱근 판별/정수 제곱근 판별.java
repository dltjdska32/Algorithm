import java.lang.Math;

class Solution {
    public long solution(long n) {
        
        double x = Math.sqrt(n);
        
        long l = (long) x;
        
        if(l*l == n){
            return (l + 1) * (l + 1);
        }
        
        return -1;
    }
    
    
  
}