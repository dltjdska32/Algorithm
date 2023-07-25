import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ArrayList<String> str = new ArrayList<>();
        int cnt = 10;
        while(N >= B){
            if(N % B <= 9){
                str.add(String.valueOf(N % B));
            }else if( N % B > 9){
                for(char c = 'A'; c <= 'Z'; c++){
                    if(cnt == (N % B)){
                        str.add(String.valueOf(c));
                        cnt = 10;
                        break;
                    }
                    cnt++;

                }
            }
            N = N / B;


        }
        if(N < B){
            if(N % B <= 9){
                str.add(String.valueOf(N % B));
            }else if( N % B > 9){
                for(char c = 'A'; c <= 'Z'; c++){
                    if(cnt == (N % B)){
                        str.add(String.valueOf(c));
                        cnt = 10;
                        break;
                    }
                    cnt++;

                }
            }
        }

        Collections.reverse(str);

         for(int i = 0; i < str.size(); i++){
            bw.write(str.get(i));
        }
        bw.flush();
        bw.close();

    }


}



