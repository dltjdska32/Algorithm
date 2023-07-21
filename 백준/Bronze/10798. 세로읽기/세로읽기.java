import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] ch = new char[5][15];

        for(int i = 0; i < 5; i++) {
            String s = br.readLine().replace(" ", "");
            char[] c = s.toCharArray();
            for(int j = 0; j < c.length; j++){
                ch[i][j] = c[j];
            }
        }

        int cnt = 0;
        String k = "";
        String str = "";
        for(int i = 0; i < 5; i++){

            for(int j = cnt; j < 15; j++) {
                if(ch[i][j] == '\0'){
                    if(i == 4){
                        i = -1;
                        cnt++;
                    }
                    break;
                }
                bw.write(ch[i][j]);
                if(true){
                    if(i == 4){
                        i = -1;
                        cnt++;
                    }
                    break;
                }
            }
        }


        bw.flush();
        bw.close();
    }


}