import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        List<Integer> nums = new ArrayList<>();
        
        for(int i = 0; i < s.length; i++){
            nums.add(Integer.parseInt(s[i]));
        }

        nums.sort((a, b) -> {
            return a - b;
        });

        int cnt = 0;
        int answer = 0;
        for(Integer num : nums) {
            cnt += num;
            answer += cnt;
        }

        System.out.println(answer);
    
    }
}