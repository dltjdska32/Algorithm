import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){

            String[] s = br.readLine().split(" ");
            int token1 = Integer.parseInt(s[0]);
            if(token1 == 1) {
                stack.push(Integer.parseInt(s[1]));
            }
            if(token1 == 2) {

                if(!stack.empty()) {
                    int popInt = stack.pop();
                    System.out.println(popInt);
                }
                else  System.out.println(-1);
               
                
            }
            if(token1 == 3) {
                int size = stack.size();
                System.out.println(size);
            }
            if(token1 == 4) {
                if(stack.size() == 0) System.out.println(1);
                else System.out.println(0);
            }
            if(token1 == 5) {
                if(!stack.empty()) System.out.println(stack.peek());
                else System.out.println(-1);
            }

            
        }

        


        br.close();
        
    }
}