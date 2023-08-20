
import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        bw.write("1");
        bw.newLine();
        bw.write(String.valueOf(menOfPassion(a, n)));

        bw.flush();
        bw.close();
        }

    public static int menOfPassion(int[] a, int n){
        int i = n / 2;
        return a[i];
    }


}