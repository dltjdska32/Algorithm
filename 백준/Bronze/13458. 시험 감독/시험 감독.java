import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //시험장당 수용 인원 배열
        ArrayList<Integer> integers = new ArrayList<>();
        // 부감독 인원 배열
        ArrayList<Integer> integers1 = new ArrayList<>();

        //시험장의 수
        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        //시험장 배열 안에 시험장인원을 추가
        for(int i = 0; i < N; i++){
            integers.add(Integer.parseInt(st.nextToken()));
        }

        String s1 = br.readLine();
        st = new StringTokenizer(s1);

        // 총감독관 감시 가능한 인원
        int B = Integer.parseInt(st.nextToken());

        // 부감독관 감시 가능 인원
        int C = Integer.parseInt(st.nextToken());

        //
        int number = 0;

        // 시험장 인원에서 총감독 감시인원 뺀값을 담을 변수
        int num = 0;

        //시험장방에서 부감독인원 구하는 풀이
        for(int i = 0; i < N; i++){
            //시험장 인원에서 총감독 감시인원 뺀 값을 num에 담음
            num = integers.get(i) - B;

            // num이 0일경우 부감독인원은 필요 없음, 0보다 클경우 부감독 인원을 구한다..
            if(num > 0) {
                // num에서 부감독 감시인원을 나눈 나머지 값이 0 이면 그대로 몫이 부감독 인원이 된다.
                if (num % C == 0) {
                    number = num / C;
                    integers1.add(number);
                    number = 0;
                }
                // num에서 부감독 감시인원을 나눈 나머지 값이 부감독 감시인원보다 작고 0 보다 클경우, 나눈값에 1을 더한다.
                else if (num % C < C && num % C > 0) {
                    number = (num / C) + 1;
                    integers1.add(number);
                    number = 0;
                }
            }
        }

        // 부감독수를 담을 변수
        long k = 0;

        // 부감독인원을 모두 더한다.
        for(long c : integers1){
            k += c;
        }

        //총감독과 부감독 값을 더한다.
        bw.write(String.valueOf(k + (long)N));

        bw.flush();
        bw.close();
        }

}

