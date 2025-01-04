import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("");
        Set<String> set = new HashSet<>();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = cnt; i < s.length; i++){
            
            sb.append(s[i]);
            set.add(sb.toString());
            
            // cnt ++ 시키고 stringbuilder초기화
            if(i == s.length -1) {
                sb.setLength(0);
                i = cnt;
                cnt++;
            }
            
        }

        System.out.println(set.size());
    
    
    
    }
    
}


