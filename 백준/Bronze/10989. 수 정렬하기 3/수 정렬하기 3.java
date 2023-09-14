

import java.io.*;
import java.nio.IntBuffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];

        for(int i = 0; i < n; i++){
            int number = Integer.parseInt(br.readLine());
            ints[i] = number;
        }

        Arrays.sort(ints);

        for(int i = 0; i < n; i++){
            bw.write(String.valueOf(ints[i]));
            bw.newLine();
        }




        bw.flush();
        bw.close();
    }



}

