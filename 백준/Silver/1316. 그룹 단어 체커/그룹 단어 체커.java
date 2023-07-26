import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String s = ""; // 다른 단어를 저장할 저장소
        int n = Integer.parseInt(br.readLine());
        int cnt = n;
        boolean b = false;
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            String[] s1 = str.split(""); // 한단어씩 쪼개서 s1배열에 저장

            if(s1.length <= 2){
                continue;
            }

            if(s1.length > 2){

                for(int j = 0; j < s1.length; j++){

                    if( j + 1 < s1.length) {
                        if (s1[j].equals(s1[j + 1])) {
                            continue;
                        }

                        if (!s1[j].equals(s1[j + 1])) {
                            if (find(s1, j + 1, s1[j]) == true) {
                                cnt--;
                                b = true;
                            }
                        }

                    }
                    if(b){
                        b = false;
                        break;
                    }
                }
            }
        }
        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();

        }

    public static boolean find(String[] s, int n, String  ss) {
        for(int i = n; i < s.length; i++){
            if(s[i].equals(ss)){
                return true;
            }
        }
        return false;
    }

}


