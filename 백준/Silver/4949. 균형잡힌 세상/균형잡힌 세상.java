import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        while(true) {

            String str = br.readLine();

            boolean b = false;
            //공백일 경우 yes
            if(str.length() >= 2 && str.trim().equals(".")) {
                System.out.println("yes");
                continue;
            }

            String[] s = str.split("");
            if(s[0].equals(".")) break;

            if(s[s.length - 1].equals(".")) {


                for(int i = 0; i < s.length; i++) {
                    // 처음 스택에 들어갈 값이 ) 이거나 ] 이면 무조건 NO
                    if(stack.size() == 0 && (s[i].equals(")") || s[i].equals("]"))){
                        System.out.println("no");
                        b = true;
                        break;
                    }

                    // ( 이거나 [일경우 스택에 넣어줌
                    if(s[i].equals("(") || s[i].equals("[")) {
                        stack.push(s[i]);
                    }

                      // 입력값이 ) 일경우 스택의 최상단 값이 ( 일경우 팝 만약 )가 들어갔는데 스택최상단이 [일경우 무조건 NO
                    if(s[i].equals(")") &&  stack.peek().equals("(")) {
                        stack.pop();
                    } else if(s[i].equals(")") &&  stack.peek().equals("[")) {
                        break;
                    }

                    // 입력값이 ] 일경우 스택 최상단 값이 [ 일경우 팝ㅇ 만약 ]가 들어갔는데 스택최상단이 (일경우 무조건 NO
                    if(s[i].equals("]") && stack.peek().equals("[")) {
                        stack.pop();
                    } else if(s[i].equals("]") &&  stack.peek().equals("(")) {
                        break;
                    }
                }


                if(stack.size() == 0 && b == false) {
                    System.out.println("yes");

                } else if(stack.size() > 0){
                    System.out.println("no");
                }
                stack.clear();
            }
        }
    }
}