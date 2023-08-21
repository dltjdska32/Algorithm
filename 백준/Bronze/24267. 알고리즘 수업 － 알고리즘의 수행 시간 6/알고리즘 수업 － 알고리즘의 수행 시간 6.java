import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());
        long k = 0;
        ArrayList<Long> longs = new ArrayList<>();

        for(int i = 1; i <= n - 2; i++){
            k += i;
            longs.add(k);
        }

        long num = 0;
        for(int i = 0; i < longs.size(); i++){
            num += longs.get(i);
        }

        bw.write(String.valueOf(num));
        bw.newLine();
        bw.write("3");

        bw.flush();
        bw.close();
    }
}