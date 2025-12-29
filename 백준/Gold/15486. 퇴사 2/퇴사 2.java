import java.io.BufferedReader;
import java.io.InputStreamReader;

///  퇴사2
public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());



        int[] t = new int[n + 2];
        int[] p = new int[n + 2];
        int[] dp = new int[n + 2];


        for(int i = 1; i <= n; i++){
            String[] s = br.readLine().split(" ");

            int tNum = Integer.parseInt(s[0]);
            int pNum = Integer.parseInt(s[1]);

            t[i] = tNum;
            p[i] = pNum;
        }

        for(int i = n; i >= 1; i--){

            if(i == n && t[i] > 1){
                continue;
            }

            ///  dp[n]에 일단 해당 날짜의 p 저장.
           if(i == n){
               dp[i] = p[i];
               continue;
           }

          ///  이후 점점 줄여가면서 dp 계산
            ///  날짜가 n을 넘어가면 스킵
            if(i + t[i] > n + 1) {
                dp[i] = dp[i + 1];
                continue;
            }

            dp[i] = dp[i + 1];
            ///  현재 날짜와 현재날짜이후 n일차이후 값을 더해서 dp와 비교
            int compVal = p[i] + dp[i + t[i]];

            int val = Math.max(compVal, dp[i]);

            dp[i] = val;
        }


        System.out.println(dp[1]);
    }
}