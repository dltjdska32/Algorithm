import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main{

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);

        s = br.readLine().split(" ");

        int[] ori = new int[s.length + 1];
        int[] sum = new int[s.length + 1];


        for(int i =0; i< s.length; i++){

            int val;

            if(s[i].equals("2")){
                val = -1;
            } else  {
                val = 1;
            }

            ori[i] = val;
        }

        for(int i = 1; i <= s.length; i++){

            int val = ori[i - 1] + sum[i - 1];

            sum[i] = val;
        }

        int max = -100000000;
        int min = 100000000;

        for(int i = 0; i < sum.length; i++){

            max = Math.max(sum[i], max);
            min = Math.min(min, sum[i]);
        }


        System.out.print(max -min);
    }
}


