class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String[] s = String.valueOf(x).split("");
        
        int val = 0;
        for(int i = 0; i < s.length; i++){
          val += Integer.parseInt(s[i]);   
        }
        
        if (x % val == 0) {
            return true;
        }
        
        return false;
    }
}