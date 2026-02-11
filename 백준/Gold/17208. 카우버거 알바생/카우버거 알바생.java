import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{


    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m, k;

    static List<String> keys = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();

    static int[][] vals;

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        vals = new int[m + 1] [k + 1];

        /// 초기값 세팅
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= k; j++){
                vals[i][j] = -1;
            }
        }

        for(int i = 0; i < n; i++){

            s = br.readLine().split(" ");

            int p = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);

            int pVal = m - p;
            int cVal = k - c;

            /// 각값이 0보다 작을경우 종료
            if(pVal < 0 || cVal < 0) continue;

            /// 첫번째는 바로 넣어주고 다음으로
            if(i == 0){
                vals[pVal][cVal] = 1;
                continue;
            }

            /// 역순으로 조회하면서 값을 찾아낸다.
            for(int j = 0; j <= m; j++){

                for(int l = 0; l <= k; l++){

                    /// 초기값 스킵
                    if(vals[j][l] == -1) continue;

                    /// 초기값이 아니면 주문 횟수 가져옴.
                    int getCnt = vals[j][l];

                    int updatedP = j - p;
                    int updatedC = l - c;

                    ///  0이하 스킵
                    if(updatedC < 0 || updatedP < 0) continue;

                    ///  0이상값의 경우 해당 위치값과 이전 주문횟수 + 1 비교해서 큰값으로 교체
                    int max = Math.max(getCnt + 1, vals[updatedP][updatedC]);

                    vals[updatedP][updatedC] = max;


                }
            }

            if(vals[pVal][cVal]== -1){
                vals[pVal][cVal] = 1;
            }
        }

        int ans = 0;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= k; j++){
                ans = Math.max(ans, vals[i][j]);
            }
        }

        if(ans == -1){
            System.out.println(0);
        } else {
            System.out.println(ans);
        }


    }


}
