

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int big = 5;
        int small = 3;

        int n = Integer.parseInt(br.readLine());
        int bigResult = 0;
        int smallResult = 0;
        boolean b1 = false;
        boolean b2 = false;


        for(int i = n / 5 + 1; i >= 0; i--){
            if(big * i > n){
                continue;
            }
            for(int j = 0; j <= n / 3 + 1; j++){

                if(big * i + small * j == n){
                    bigResult = i;
                    smallResult = j;
                    b1 = true;
                    break;
                }
                if((i == 0 && j == n / 3 + 1) && big * i + small * j != n){
                    b2 = true;
                }
            }
            if(b1){
                break;
            }
        }

        if(b2 || n == 0){
            bw.write("-1");
        }else{
            bw.write(String.valueOf(bigResult + smallResult));
        }

        bw.flush();
        bw.close();
    }
}
