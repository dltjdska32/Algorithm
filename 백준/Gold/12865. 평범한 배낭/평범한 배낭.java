import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]); // 물건 최대갯수
        int k = Integer.parseInt(str[1]); // 리미트 무게

        int[] dp = new int[k + 1];  // 0 ~ k 만큼의 무게를 담을 배열의방


        for(int i = 0; i  < n; i++){
            str = br.readLine().split(" ");
            int w = Integer.parseInt(str[0]); //물건 무게
            int v = Integer.parseInt(str[1]); //가치

            if(w > k){
                continue;
            }

            int key = 0;
            int value = 0;


// 틀린 풀이 -> for문을 실행할때 최고값을 계속해서 갱신할수없음  0 ~ k 까지실행하면
/*

            // for문을 돌때 갱신한값을 또 갱신할 수 있기때문에

            // 0 ~ k-w까지의 거리중 최고값을 가지는 방의 번호를 key에저장 값을 value에저장
            //그다음 w 와 해당 key를 합한 방에 v 와 value를 합한값을 비교해서 max를 해당 방에 저장
            // dp[key + w] = max(dp[key + w], v +value)
//            for(int j = 0; j < k + 1 - w; j++){
//                int cmpValue = dp[j];
//                if(value < cmpValue) {
//                    value = cmpValue;
//                    key = j;
//                }
//            }

//            만약 key 가 0이고 해당방에 값이없다면. dp[w] = v;
//            if(key == 0 && dp[w] == 0) {
//                dp[w] = v;
//                continue;
//            }
//
//            dp[key + w] = max(dp[key + w], v + value);
*/

            // 맞은 풀이법.

            // k ~ 1까지 최고값을 가지는 방의 번호르 key에 저장 값을 value에 저장
            //  k 번의 방의경우 더이상 무게를추가할수없으므로 k -1부터 시작
            // dp 방의 값을 계속해서 갱신해야하기 때문에 dp 방 최대 크기 -1 부터 역으로 for문 실행
            for(int j = k - 1; j >= 0; j--){
                int compValue = dp[j];
                // j + w가 k를 넘을 경우 담을수 없기 때문에 continue;
                if(j + w > k) {
                    continue;
                }

                // 갱신할 dp방에 갱신된 최고값을 넣어준다.
                dp[j + w] = max(dp[j + w], v + compValue);
            }


        }

        int answer = 0;
        for(int i = 0; i < dp.length; i++){
            if(answer < dp[i]){
                answer = dp[i];
            }
        }

        System.out.println(answer);
    }

    public static int max(int num, int compNum){
        if(num > compNum){
            return num;
        }
        return compNum;
    }
}
