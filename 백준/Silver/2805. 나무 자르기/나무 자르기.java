import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = 0;
        long m = 0;
        String[] str = br.readLine().split(" ");
        n = Long.parseLong(str[0]);
        m = Long.parseLong(str[1]);

        long answer = 0;
        long high = 0;
        long low = 0;
        List<Long> lengths = new ArrayList<>();

        str = br.readLine().split(" ");

        for (String s : str) {
            if(Long.parseLong(s) >= high) {
                high = Long.parseLong(s);
            }
            lengths.add(Long.parseLong(s));
        }

   
        
        while (low <= high) {
            long mid = (high + low) / 2;
            long size = 0;

            // 길이를 구함
            for(Long length : lengths) {
                 if(length < mid) continue;

                 size += length - mid;
            }

            // 만약 size 가 m 보다 클경우
            // low를 mid + 1로 변경
            // 아닐경우 high를 mid -1 로 변경
            if(size >= m) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        System.out.print(answer);

    }
}