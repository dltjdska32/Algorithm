import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 1; // 몇번 거치는지 횟수 카운트
        int k = 1; // 초기값
        int n = 6; // 6의 배수로 추가

        int num = Integer.parseInt(br.readLine()); // 입력받은값 - 찾아야 할 위치의 값

        while(num > k){

            k += n * cnt;
            cnt++;
        }

        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();

        }


}

