import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 1) {

            String[] s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            System.out.println(Math.abs(a- b));
            return;
        }

        int[][] arr = new int[n + 1][2];

        for(int i = 0; i < n; i ++){
            String[] s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            arr[i][0] = a;
            arr[i][1] = b;
        }


        int min = 1000000000;

        ///  모든경우의수 순회.
        for(int i = 1; i < (1 << n); i++){

            int s = 1;
            int b = 0;

            /// 실제 조합만들기.
            for(int j =0; j < n; j++){

                ///  i       j
                ///  0001 ~ 1111 까지
                ///  0001 & 0001 => 1
                ///  0001 & 0010 => 0
                ///  0010 & 0011 => 2
                if((i & (1<<j)) != 0) {
                    s *= arr[j][0];
                    b += arr[j][1];
                }
            }

            min = Math.min(min, Math.abs(s - b));
        }

        System.out.println(min);
    }
}