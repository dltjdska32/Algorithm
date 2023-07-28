import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];

        String s = br.readLine();
        String[] strings = s.split(" ");
        int cnt = 0;
        int count = 0;
        for(int i = 0; i < n; i++){

            num[i] = Integer.parseInt(strings[i]);
            if(num[i] == 1){
                continue;
            }
            for(int j = 1; j <= num[i]; j++){
                if(num[i] % j == 0){
                    cnt++;
                }
            }
            if(cnt == 2){
                count++;
                cnt = 0;
            }else{
                cnt = 0;
            }
        }
        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();

        }


}
