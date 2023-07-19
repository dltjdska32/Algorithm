import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine().replace(" ","");
        String[] str = new String[8];
        str[0] = "c=";
        str[1] = "c-";
        str[2] = "dz=";
        str[3] = "d-";
        str[4] = "lj";
        str[5] = "nj";
        str[6] = "s=";
        str[7] = "z=";

        int cnt = 0;

        int k = 0;
        for(int i = 0; i < 8; i++){

            if(s.contains(str[i])){

                s = s.replace(str[i], ",");

            }
        }
        int value = s.length();
        bw.write(String.valueOf(value));

        bw.flush();
        bw.close();
    }
}
