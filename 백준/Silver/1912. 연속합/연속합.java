import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] str = br.readLine().split(" ");

        List<Integer> dpList = new ArrayList<>();

        for(int i = 0; i < str.length; i++) {
            int input = Integer.parseInt(str[i]);

            // i == 0 일경우 dp 어레이에 저장.
            if(i == 0) {
                dpList.add(input);
                continue;
            }

            // 디피 어레이에 저장된 이전 값 가져옴.
            int comp = dpList.get(i - 1);

            // 인풋과 인풋 + comp(이전에 저장된 최댓값) 비교
            int maxInt = max(input, input + comp);

            dpList.add(maxInt);
        }

        Integer answer = dpList.stream().max(Integer::compare).orElse(0);

        System.out.println(answer);
    }

    public static int max (int input, int compareInt) {
        if(input >= compareInt) {
            return input;
        }
        return compareInt;
    }
}
