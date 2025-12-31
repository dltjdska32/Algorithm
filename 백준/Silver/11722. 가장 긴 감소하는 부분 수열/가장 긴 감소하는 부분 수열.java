import java.io.BufferedReader;
import java.io.InputStreamReader;

/// 가장 긴 감소 부분 수열 (lis)
///  n = 1000
///  dp로 풀경우 1000 ^ 2 --> 10000000 1초 안에 가능

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");

        /// dp 배열생성
        /// 각위치의 lis갯수저장.
        int[] dp = new int[n+1];

        int ans = 0;
        for(int i = 0; i < n; i++){

            int v =  Integer.parseInt(s[i]);

            if (i == 0){
                dp[i] = 1;
                ans = Math.max(ans, dp[i]);
                continue;
            }

            int max = 0;
            for(int j = 0; j < i; j++){

                int compV = Integer.parseInt(s[j]);


                if(v < compV){
                   max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max+1;

            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}