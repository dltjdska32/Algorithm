import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    static int n, m;

    static int[][] arr,comp;
    static int[][] isVisited;

    static int max = -1000000000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n + 1][m + 1];

        // 1,1 을기준으로 누적합을 구한다.
        for(int i = 1; i <= n; i++){

            s = br.readLine().split(" ");

            for(int j = 1; j <= m; j++){

                int num = Integer.parseInt(s[j -1]);

                arr[i][j] = num + arr[i -1][j] + arr[i][j -1] - arr[i-1][j-1];

            }
        }

        /// 각영역을 기준으로 사각형 영역을 모두구한다.
        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= m; j++){

                for(int k = i; k <= n; k++){

                    for(int l = j; l <= m; l++){

                        ///  k, l 타겟 지점.
                        ///  i, j 시작 지점.
                        ///  시작지점 ~ 목표 지점 값을 구한다.
                        int val = arr[k][l] //1, 1 부터 목표까지의 최대값
                                    - arr[i - 1][l] //1,1 부터 시작지점 y값바로 위 영역 제거
                                    - arr[k][j - 1] // 1, 1부터 시작지점 x값 바로 왼쪽 영역제거
                                    + arr[i - 1][j -1];

                        max = Math.max(val, max);
                    }
                }

            }
        }

        System.out.println(max);
    }


}