import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int quater = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;
        int cnt = 0;
        int[] result = new int[4];
        String[] s = new String[t];
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            if(n >= quater) {
                while (n >= quater) {
                    n -= quater;
                    cnt++;
                }
                result[0] = cnt;
                cnt = 0;
            }
            if( n < quater && n >= dime){
                while(n < quater && n >= dime){
                    n -=     dime;
                    cnt++;
                }
                result[1] = cnt;
                cnt = 0;
            }
            if(n < dime && n >= nickel){

                while(n < dime && n >= nickel) {
                    n -= nickel;
                    cnt++;
                }

                result[2] = cnt;
                cnt = 0;
            }
            if(n < nickel && n >= penny){
                while(n < nickel && n >= penny) {
                    n -= penny;
                    cnt++;
                }
                result[3] = cnt;
                cnt = 0;

            }
            s[i] = String.valueOf(result[0]) + " "+ String.valueOf(result[1]) +
                    " "  + String.valueOf(result[2]) + " " + String.valueOf(result[3]);
            result[0] = 0;
            result[1] = 0;
            result[2] = 0;
            result[3] = 0;
        }

        for(int i = 0; i < t; i++){
            bw.write(s[i]);
            bw.newLine();
        }


            bw.flush();
            bw.close();

        }


}



