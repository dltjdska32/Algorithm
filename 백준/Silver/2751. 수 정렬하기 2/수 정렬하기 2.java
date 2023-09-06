import java.io.*;
import java.nio.IntBuffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> integers = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            integers.add(num);
        }

        Collections.sort(integers);

        for(int element : integers){
            bw.write(String.valueOf(element));
            bw.newLine();
        }



        bw.flush();
        bw.close();
    }



}
