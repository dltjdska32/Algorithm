import java.io.*;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] num = new int[n][2];


        for(int i = 0; i < n; i++) {

            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            num[i][0] = Integer.parseInt(st.nextToken());  // x 값
            num[i][1] = Integer.parseInt(st.nextToken());  // y 값

        }

        if(n == 1){
            bw.write("0");
        }else if(n > 1) {
            int x = num[0][0]; // x 의 최솟값을 담을 변수
            int x1 = num[0][0]; // x 의 최댓값을 담을 변수
            int y = num[0][1]; //y 의 최솟값을 담을 변수
            int y1 = num[0][1]; // y 의 최댓값을 담을 변수

            for (int i = 0; i < n; i++) {
                if (num[i][0] < x) {
                    x = num[i][0];
                }
                if (num[i][0] > x1) {
                    x1 = num[i][0];
                }
            }

            for (int i = 0; i < n; i++) {
                if (num[i][1] < y) {
                    y = num[i][1];
                }
                if (num[i][1] > y1) {
                    y1 = num[i][1];
                }
            }

            int xLength = x1 - x;
            int yLength = y1 - y;


            bw.write(String.valueOf(xLength * yLength));
        }
        bw.flush();
        bw.close();
        }

}