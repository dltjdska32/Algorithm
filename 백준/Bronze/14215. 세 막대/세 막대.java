
import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(a);
        integers.add(b);
        integers.add(c);


        int max = Collections.max(integers);


        integers.remove((Integer) max);

        if(max < integers.get(0) + integers.get(1)){
            bw.write(String.valueOf(a + b + c));
        }else{
            max = integers.get(0) + integers.get(1) - 1;
            integers.add(max);

            bw.write(String.valueOf(integers.get(0) + integers.get(1) + integers.get(2)));
        }


        bw.flush();
        bw.close();
        }




}
