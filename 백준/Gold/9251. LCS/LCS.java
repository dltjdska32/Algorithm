import java.io.BufferedReader;
import java.io.InputStreamReader;

///  퇴사2
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");

        int[][] dp =  new int[str1.length + 2][str2.length + 2];

        int ans = 0;

        /// LSC 문제 풀이법
        ///  2차원 배열로 만들어서 각각의 문자가 같다면? -> 왼쪽위 값에 + 1
        ///  다르다면? 왼족값과 위쪽값의 최댓값
        for(int i = 1; i < str1.length + 1; i++){
            for(int j = 1; j < str2.length + 1; j++){

                if(str1[i - 1].equals(str2[j - 1])){

                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        System.out.println(ans);
    }
}