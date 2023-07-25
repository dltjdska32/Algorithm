import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        String strings = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        String[] str = strings.split(""); // 입력된 문자열을 str배열에 담음
        int cnt = 9;  // 9까지 정수
        int k[] = new int[str.length]; // 스트링형 형태로 저장된 str 배열값들을 인트형으로 저장하기 위한 저장소

        for(int  i = 0; i < str.length; i++){
            try{ // str 배열값이 정수면 k배열에 인티저형변환을 하여 저장
                k[i] = Integer.parseInt(str[i]);
            }catch(NumberFormatException e){
                // str배열에 저장된 값이 문자면 인트형 cnt를 ++ 해가면서 일치하는값을 찾아 인트형 배열k[i]에 저장
                for(char a = 'A'; a <= 'Z'; a++){
                    ++cnt;   // A = 10 ~ Z = 35;
                    if(str[i].equals(String.valueOf(a))){
                        k[i] = cnt;
                        cnt = 9;
                        break;
                    }
                }
            }
        }
        int result = 0;
        int kLength = k.length - 1;
        for(int i = 0; i < k.length;  i++) {
            result += k[i] * Math.pow(n, kLength);
            kLength--;
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();

    }


}
