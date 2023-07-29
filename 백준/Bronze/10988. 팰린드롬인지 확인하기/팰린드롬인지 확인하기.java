import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        char[] c = s.toCharArray();
        char[] a = new char[c.length / 2];
        char[] b = new char[c.length / 2];
        char[] d = new char[b.length];
        int j = 0;
        if(c.length % 2 == 1) {
            for (int i = 0; i < c.length; i++) {
                if (i < c.length / 2) {
                    a[i] = c[i];
                }
                if (i > c.length / 2) {
                    b[j] = c[i];
                    j++;
                }
            }
        }
        if(c.length % 2 == 0){
            for (int i = 0; i < c.length; i++) {
                if (i < c.length / 2) {
                    a[i] = c[i];
                }
                if (i >= c.length / 2) {
                    b[j] = c[i];
                    j++;
                }
            }
        }
        int k = 0;
        for(int i = b.length -1 ; i >= 0; i--){
            d[k] = b[i];
            k++;
        }

        String str1 = new String(a);
        String str2 = new String(d);

        if(str1.equals(str2)){
            bw.write("1");
        }else if(!str1.equals(str2)){
            bw.write("0");
        }


        bw.flush();
        bw.close();
    }



}


