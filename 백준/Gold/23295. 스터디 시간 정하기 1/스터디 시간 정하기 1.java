import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    static final int MAX = 100001;
    static int n, t;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        t = Integer.parseInt(s[1]);

        long[] arr = new long[MAX];


        for(int i =0; i < n; i++){
            int k = Integer.parseInt(br.readLine());

            for(int j = 0; j < k; j++){

                s = br.readLine().split(" ");

                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);

                /// 해당 구간에 들어가고 종료하는 시간을 구간저장
                ///  구간을 저장해야 추가로 반복문 안돌음
                arr[start]++;
                arr[end]--;

            }
        }


        /// 실제 0~ t까지의 인원수 구함.
        ///  arr 에는 0 ~ 3 이라고한다면
        ///  arr[0] = 1  / arr[1] = 0/ arr[2] = 0/ arr[3] = -1이렇게 저장되어있음
        /// 따라서 모든 포문을 돌면서 실제값을 생성
        for(int i = 1; i < MAX; i++){
            arr[i] += arr[i -1];
        }

        /// 구간별 누적해서 사람 저장
        ///  이렇게해야 반복문을 돌지않음
        ///  ex)
        ///  sum[0] = 0
        /// sum[1] = 0 + arr[0] = 1
        /// sum[2] = 1 + arr[1] = 2
        /// sum[3] = 2 + arr[2] = 3
        /// sum[4] = 3 + arr[3] = 10
        ///  t = 2 일경우
        ///  0 ~ 2 일경우 3  - 실제값은 2-0 = 2
        ///  1 ~ 3일경우 10 - 실제값은 3-1 = 2
        ///  2 ~ 4일경우 10 - 2 = 8
        long[] sum = new long[MAX];
        for(int i = 1; i < MAX; i++){
        sum[i] = sum[i -1] + arr[i -1];
        }

        long val = 0;
        int start = 0;

        /// 최대 10000 - t까지 순회
        for(int i = 0; i <= MAX - 1 - t; i++){

            /// 값계산
            long curVal = sum[i + t] - sum[i];

            if(curVal > val) {
                val = curVal;
                start = i;
            }
        }

        int end = start + t;
        System.out.println(start + " " + end);

    }
}