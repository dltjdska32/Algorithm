

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int [][] dp = new int[n][3];
            int [][] comp = new int[n][3];


            for(int i = 0; i < n; i++){
                String[] str= br.readLine().split(" ");
                int f = Integer.parseInt(str[0]);
                int m = Integer.parseInt(str[1]);
                int l = Integer.parseInt(str[2]);


                comp[i][0] = f;
                comp[i][1] = m;
                comp[i][2] = l;
            }

            for(int i = 0; i < n; i++){
                if(i == 0) {
                    dp[0][0] = Integer.MAX_VALUE/2 ;
                    dp[0][1] = comp[0][1];
                    dp[0][2] = comp[0][1] + comp[0][2];
                    continue;
                }

                //1열
                int[] arr = new int [2];
                arr[0] = dp[i -1][0];
                arr[1] = dp[i -1][1];

                dp[i][0] = min(arr) + comp[i][0];

                //2열
                arr = new int[4];
                arr[0] = dp[i][0];
                arr[1] = dp[i-1][0];
                arr[2] = dp[i-1][1];
                arr[3] = dp[i-1][2];
                dp[i][1] = min(arr)+ comp[i][1];

                //3열
                arr = new int [3];
                arr[0] = dp[i][1];
                arr[1] = dp[i-1][1];
                arr[2] = dp[i-1][2];
                dp[i][2] = min(arr) + comp[i][2];

            }

            System.out.println(testCase + ". "  + dp[n - 1][1]);
            testCase++;
        }

    }

    public static int min(int[] arr){
        Integer min = null;
        for(int i = 0; i < arr.length; i++){
            if (min == null){
                min = arr[i];
                continue;
            }
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}
