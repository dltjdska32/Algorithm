class Solution {
    public int[] solution(long n) {
        
        String[] s = String.valueOf(n).split("");
        
        
        int[] answer = new int[s.length];
        
        int j =0;
        for(int i = s.length - 1; i >= 0; i--){
            answer[j] = Integer.parseInt(s[i]);
            j++;
        }
        
        return answer;
    }
}