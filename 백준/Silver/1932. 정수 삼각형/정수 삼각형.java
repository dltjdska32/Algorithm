
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

            int[][] dpArray = new int[n][n];

            for(int i = 0; i < n; i++){
                String[] str = br.readLine().split(" ");
                // 초기값 세팅
                if (i == 0) {
                    dpArray [0][0] = Integer.parseInt(str[0]);
                    continue;
                }

                //두번째 부터
                for(int j = 0; j < str.length; j++){
                    int input = Integer.parseInt(str[j]);

                    // 입력받은 숫자들중 첫번째 숫자의경우 이전 dpArray의 첫번재값과 더하고 dparray에 추가해준다.
                    if (j == 0){
                        dpArray[i][j] = dpArray[i - 1][0] + input;
                        continue;
                    }

                    // 입력받은 숫자들중 마지막숫자의 경우 이전dpArray의 마지막값과 더하고 dparray에 추가해준다.
                    if(j == str.length -1) {
                        dpArray[i][j] = dpArray[i - 1][str.length - 2] + input;
                        continue;
                    }

                    // 첫번째 마지막 입력숫자가 아니면 이전 dparray의 좌우값중 최댓값을 input에 더하고 dparray에 추가해준다.
                    dpArray[i][j] = input + max(dpArray[i - 1][j - 1], dpArray[i - 1][j]);
                }
            }

            int answer = 0;
            // 답찾기
            for (int i = 0; i < n; i++) {
                if(answer < dpArray[n - 1][i]) {
                    answer = dpArray[n - 1][i];
                }
            }
            System.out.println(answer);
        }

        public static int max(int num, int compNum) {
            int max = 0;
            if (num > compNum){
                return max = num;
            }

            return max = compNum;
        }
    }
