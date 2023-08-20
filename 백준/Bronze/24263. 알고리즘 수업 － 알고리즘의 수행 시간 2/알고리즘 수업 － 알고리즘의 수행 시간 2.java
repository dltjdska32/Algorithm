import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        bw.write(String.valueOf(menOfPassion(a, n)));
        bw.newLine();
        bw.write("1");

        bw.flush();
        bw.close();
        }

    public static int menOfPassion(int[] a, int n){

        int cnt = 0;
        for(int i = 0; i < n; i++){

            cnt++;
        }
        return cnt;
    }


}