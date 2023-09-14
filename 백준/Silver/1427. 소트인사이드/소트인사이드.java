import java.io.*;
import java.nio.IntBuffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int strNumberLength = str.length();

        String[] strNumber = str.split("");

        ArrayList<Integer> integers = new ArrayList<>();

        for(int i = 0 ; i < strNumberLength; i++){
            integers.add(Integer.parseInt(strNumber[i]));
        }

        Collections.sort(integers);
        Collections.reverse(integers);

        for(int i = 0; i < integers.size(); i++){
            bw.write(String.valueOf(integers.get(i)));

        }

        bw.flush();
        bw.close();
    }



}