import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/// 가장 긴 바이토닉 부분 수열 (lis)
/// 1000 ^ 2  -> 1억 이하.
/// dp
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");

        int[] incDp = new int[n];
        int[] decDp = new int[n];

        Arrays.fill(incDp, 1);
        Arrays.fill(decDp, 1);


        for(int i = 0; i < n; i++){

            int num = Integer.parseInt(s[i]);

            ///  0 ~ comp 까지 비교
            int incMax = 0;
            for(int j = 0; j <= i; j++){

                int compNum =  Integer.parseInt(s[j]);

                if(compNum < num){
                    incMax = Math.max(incMax, incDp[j]);
                }
            }


            incDp[i] = incMax + 1;
        }





        for(int i = n - 1; i >= 0; i--){

            int num = Integer.parseInt(s[i]);

            int decMax = 0;
            for(int j = i; j < n; j++){

                int compNum =  Integer.parseInt(s[j]);

                if(num > compNum){
                    decMax = Math.max(decMax, decDp[j]);
                }
            }



            decDp[i] = decMax + 1;
        }




        int ans = 0;
        for(int i = 0; i < n; i++){

            int incVal = incDp[i];
            int decVal = decDp[i];

            int val = incVal + decVal - 1;

            ans = Math.max(ans, val);
        }

        System.out.println(ans);
    }
}