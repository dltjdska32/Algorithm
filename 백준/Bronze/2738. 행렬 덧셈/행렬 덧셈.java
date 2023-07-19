import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

         String s = br.readLine();

         StringTokenizer st = new StringTokenizer(s);

         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());

         Integer[][] integers = new Integer[N][M];
         Integer[][] integers1 = new Integer[N][M];

         for(int i = 0; i < N; i++){
             s = br.readLine();
             st = new StringTokenizer(s);
             for(int j = 0; j < M; j++){
                 integers[i][j] = Integer.parseInt(st.nextToken());
             }
         }

        for(int i = 0; i < N; i++){
            s = br.readLine();
            st = new StringTokenizer(s);
            for(int j = 0; j < M; j++){
                integers1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){

            for(int j = 0; j < M; j++){
                integers[i][j] += integers1[i][j];
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                bw.write(integers[i][j] + " ");
            }
            bw.newLine();
        }


        bw.flush();
        bw.close();
    }
}
