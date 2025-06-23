

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    public class Main {
        public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n][3];

            String[] str = br.readLine().split(" ");
            //초기값 세팅
            for(int i = 0; i < 3; i++){
                int input = Integer.parseInt(str[i]);

                dp[0][i] = input;
            }

            // 2번째 집부터
            for(int i = 1; i < n; i++){
                str = br.readLine().split(" ");

                for(int j = 0; j <str.length; j++){
                    int input = Integer.parseInt(str[j]);
                    // 입력값이 R일경우
                    // 이전 G 와 B를 비교해서 이전 값의 최솟값과 input값의 합을 dp배열에 저장.
                    if(j == 0){
                        dp[i][j] = input + min(dp[i-1][1], dp[i-1][2]);
                    }

                    if(j == 1){
                        dp[i][j] = input + min(dp[i-1][0], dp[i-1][2]);
                    }

                    if(j == 2){
                        dp[i][j] = input + min(dp[i-1][0], dp[i-1][1]);
                    }
                }
            }

            Integer answer = null;
            //답찾기
            for(int i = 0; i < 3; i++){
                if(answer == null) {
                    answer = dp[n - 1][i];
                    continue;
                }

                if(answer > dp[n - 1][i]){
                    answer = dp[n - 1][i];
                }
            }
            System.out.println(answer);
        }

        public static int min(int num, int compNum) {
            int min = 0;
            if(compNum > num) {
                min = num;
            } else {
                min = compNum;
            }
            return min;
        }
    }
