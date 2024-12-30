import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split("");
            for(int j = 0; j < s.length; j++){
                // 처음 문자가 " ) " 이면   무조건 NO
                if(s[0].equals(")")) {stack.push(s[j]); break;}
                // " ( " 문자가 나오면 우선 진행(스택에 추가)
                if(s[j].equals("(")) {stack.push(s[j]);}
                // 스택이 비어있는 상태에서 " ) " 이 들어가면 무조건 NO
                if(stack.empty() && s[j].equals(")")) {stack.push(s[j]); break;}
                // " ) " 문자가 나오면 스택에서 팝
                if(s[j].equals(")")) {stack.pop();}
            }
            //스택이 비어있으면 YES / 스택에 하나라도 있으면 NO
            if(!stack.empty()) System.out.println("NO");
            if(stack.empty()) System.out.println("YES");
            
            // 다음 스택 추가를 위해 스택 비움
            stack.clear();
        }
    }
}