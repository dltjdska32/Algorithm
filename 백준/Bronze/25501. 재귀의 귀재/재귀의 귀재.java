import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int cnt = 0;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            int answer = isPalindrome(s);
            System.out.println(answer + " " + cnt);
            cnt = 0;
        }
        
        
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    public static int recursion(String s, int start, int end) {
        if(start >= end) {
            cnt++;
            return 1;
        }
            else if(s.charAt(start) != s.charAt(end)){
                cnt++;
                return 0;
            }

        cnt++;
        return recursion(s, start+1, end-1);
    } 
    
}