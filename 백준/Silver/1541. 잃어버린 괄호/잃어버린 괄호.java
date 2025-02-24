import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Queue<String> q = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();
        List<String> operator = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split("");

        //입력받은값이 연산자면 연산자리스트에추가 숫자일경우 연산자가 나오기 전까지의 숫자를 nums리스트에 추가
        for(int i = 0; i < s.length; i++) {
        
            if(s[i].equals("-") || s[i].equals("+")) {
            
                operator.add(s[i]);
                nums.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
                
            } else {
                sb.append(s[i]);
                if(i == s.length -1) {
                    nums.add(Integer.parseInt(sb.toString()));
                }
            }
        }    
          
        int check = 0;

        // 연산자리스트에서 현재연산자의 인덱스 앞에 -가있고 현재연산자가 +라면 -로 변경해줌.
        for (String op : operator) {
            if(check > 0 && operator.get(check - 1).equals("-") && op.equals("+")) {
                operator.set(check, "-");
            } 
            check++;
        }

        int answer = 0;

          
        // 연산자 리스트를 순회하면서 값을 계산해준다.  
        for(int i = 0; i < operator.size(); i++) {
            if(i == 0) {
                answer = nums.get(i);
            }

            if(operator.get(i).equals("-")) {
                answer -= nums.get(i+1);
                continue;
            }

            if(operator.get(i).equals("+")) {
                answer += nums.get(i+1);
            }
        }


        // 만약 nums의 사이즈가 1일경우 -나 + 입력받은 값이 없기 때문에 nums.get(0)만출력
        if(nums.size() == 1) {
            answer = nums.get(0);
        }
        
        System.out.println(answer);

       
    }
}