class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int s , e ;
        
        if(a < b) {
            s = a; 
            e = b;
        } else {
            s = b;
            e = a;
        }
        for(int i = s; i <= e; i++){
            answer += i;
        }
        
        return answer;
    }
}