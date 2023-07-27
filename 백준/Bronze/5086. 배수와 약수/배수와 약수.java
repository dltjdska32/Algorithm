
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> str = new ArrayList<>();
        String s = "";
        while(!s.equals("0 0")){
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N != 0 && M != 0) {
                if (N != 0 && M % N == 0 && N <= M) {
                    String string = "factor";
                    str.add(string);
                } else if (M != 0 && N % M == 0 &&  N >= M) {
                    String string = "multiple";
                    str.add(string);
                } else {
                    String string = "neither";
                    str.add(string);
                }
            }
        }


        for(int i = 0; i < str.size(); i++){
            bw.write(str.get(i));
            bw.newLine();
        }


        bw.flush();
        bw.close();

        }


}
