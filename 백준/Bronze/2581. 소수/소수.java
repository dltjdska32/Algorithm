import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int cnt = 0;

        ArrayList<Integer> integers = new ArrayList<>();

        for(int i = n; i <= m; i++){
            for(int j = 1; j <= i; j++){
                if(i % j == 0){
                    cnt++;
                }
            }
            if(cnt == 2){
                integers.add(i);
                cnt = 0;
            }
            cnt = 0;
        }
        int k = 0;
        for(int i = 0; i < integers.size(); i++){
            k += integers.get(i);
        }

        if(!integers.isEmpty()) {
            bw.write(String.valueOf(k));
            bw.newLine();
            int min = Collections.min(integers);
            bw.write(String.valueOf(min));
        }else{
            bw.write("-1");
        }
        bw.flush();
        bw.close();

        }


}




