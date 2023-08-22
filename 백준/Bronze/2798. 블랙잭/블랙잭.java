import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        ArrayList<Integer> integers = new ArrayList<>();

        String s1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(s1);

        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st1.nextToken());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
               for(int k = 0; k < n; k++){
                   if(k == j || k == i){
                       continue;
                   }
                   if (array[i] + array[j] + array[k] <= m){
                       integers.add(array[i] + array[j] + array[k]);
                   }
               }
            }
        }

        bw.write(String.valueOf(Collections.max(integers)));


        bw.flush();
        bw.close();
    }
}