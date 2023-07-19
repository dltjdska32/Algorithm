import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] ints = new int[9][9];
        for(int i = 0; i < 9; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for(int j = 0; j < 9; j++){
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = ints[0][0];
        int k = 0;
        int k1 = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(max <= ints[i][j]){
                    max = ints[i][j];
                    k = i + 1;
                    k1= j + 1;
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(k) + " " + String.valueOf(k1));
        bw.flush();
        bw.close();
    }
}
