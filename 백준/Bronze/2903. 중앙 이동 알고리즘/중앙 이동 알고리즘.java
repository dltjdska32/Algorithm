import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int num = 0;
        int k = 2;
        int cnt = 1;
        int nextNum = 0;
        for(int i = 1; i <= n; i++ ){
            k = k + cnt;
            nextNum = (int) Math.pow(k, 2);

            cnt *= 2;
        }

        bw.write(String.valueOf(nextNum));
        bw.flush();
        bw.close();

        }


}





