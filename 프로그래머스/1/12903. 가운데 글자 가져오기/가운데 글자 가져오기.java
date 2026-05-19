class Solution {
    public String solution(String s) {
        String answer = "";
 
        
        String[] str = s.split("");
        
               
        int sl = str.length / 2;
        
        if (str.length % 2 == 0){
            answer += str[sl-1];
            answer += str[sl ];
        } else {
            answer += str[sl];
        }
        
        return answer;
    }
}