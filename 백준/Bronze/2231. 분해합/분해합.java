
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 분해합 문제 -> 입력 N = 분해합 , M = 생성자
        // 생성자(M) + M의 첫번째자릿수 + 두번째자리수 + .... + 마지막자리수 = N 분해합
        // 가장작은 생성자를 찾는문제.

        //분해합을 문자형(s)에 입력을 받응후 s를 인트형 N으로 변환
        String s = br.readLine();
        int N = Integer.parseInt(s);


        // 가작 작은 생성자를 찾기위해
        // 0부터 N 까지 i를 ++ 시키면서 생성자를 찾는다.
        for(int i = 0; i < N; i++){

            //i를 자리수 마다 자르기 위해 문자형으로 형변환
            String string = String.valueOf(i);
            String[] strs = string.split("");

            //i의 각 자리수의 합을 담을 변수 k
            int k = 0;

            for(int j = 0; j < strs.length; j++){
                k += Integer.parseInt(strs[j]);
            }

            //만약 분해합(N)이 생성자(i) + 생성자 각 자리수의 합(k) 와같다면
            //출력후 for문 탈출
            if(N == i + k){
                bw.write(String.valueOf(i));
                break;
            }
            //생성자가 없을경우 0을 출력
            if(i == N - 1 && N != i + k){
                bw.write("0");
            }

        }

        bw.flush();
        bw.close();
    }
}
