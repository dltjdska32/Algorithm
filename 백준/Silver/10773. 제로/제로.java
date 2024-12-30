import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        
        int sum = 0;
        
        for(int i = 0; i < k; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && stack.empty()) continue;

            if(num == 0 && !stack.empty()) stack.pop();

            if(num > 0) stack.push(num);
        }
        int size = stack.size();
        for(int j = 0; j < size; j++){
            sum += stack.pop();    
        }

        System.out.println(sum);
    }
}