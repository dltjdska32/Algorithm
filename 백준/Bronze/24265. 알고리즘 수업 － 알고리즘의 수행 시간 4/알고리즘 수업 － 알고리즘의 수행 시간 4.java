import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long k = 0;

        for(int i = 1; i < n; i++){
            k += i;
        }

        bw.write(String.valueOf(k));
        bw.newLine();
        bw.write("2");
        bw.flush();
        bw.close();
    }

}