import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> integers = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            if(N % i == 0){
                integers.add(i);
            }
            if(integers.size() == K){
                break;
            }
        }
        if(integers.size() < K){
            bw.write("0");
        } else if(integers.size() >= K) {
            bw.write(String.valueOf(integers.get(K - 1)));
        }
        bw.flush();
        bw.close();

        }


}
