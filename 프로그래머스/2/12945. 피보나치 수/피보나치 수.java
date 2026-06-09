class Solution {
  
    public int solution(int n) {
        int answer = 0;
        
         int[]  dp = new int[n + 3];
        
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 0; i <= n; i++){
            
            
            if(i == 0) {
                dp[i] = 0;
                continue;
            }
            
            if (i == 1) {
                dp [i] = 1;
                continue;
            }
            
            dp[i] = (dp[i - 2] + dp[i -1]) % 1234567;

            
        }
        
        answer = dp[n];
        
        return answer;
    }
}