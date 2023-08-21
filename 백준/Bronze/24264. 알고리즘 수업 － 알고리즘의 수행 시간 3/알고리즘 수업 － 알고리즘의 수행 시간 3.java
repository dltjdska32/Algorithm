import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());
        long num = n * n;



        bw.write(String.valueOf(num));
        bw.newLine();
        bw.write("2");
        bw.flush();
        bw.close();
    }


}