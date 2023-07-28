import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if(n % i == 0){
                integers.add(i);
                n = n / i;
                i--;

            }

        }

        for(int i = 0; i < integers.size(); i++){
            bw.write(String.valueOf(integers.get(i)));
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }

}