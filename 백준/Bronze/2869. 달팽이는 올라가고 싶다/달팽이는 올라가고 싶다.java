import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int num = V - A;
        int num1 = A - B;

        int k = 0;
        if(A == V){
            bw.write("1");
        }else if(V > A) {
            if (num < num1) {
                k = 1;
            } else if (num > num1) {
                if (num % num1 == 0) {
                    k = num / num1;
                }
                if (num % num1 > 0) {
                    k = num / num1 + 1;
                }
            }

            bw.write(String.valueOf(k + 1));
        }
        bw.flush();
        bw.close();
    }

}