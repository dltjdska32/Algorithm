
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == -1){
                break;
            }
            int k = 0;
            for(int i = 1; i <= n / 2; i++){
                if(n % i == 0){
                    k += i;
                    integers.add(i);
                }
            }
            if(k == n){
                String str = n + " = ";
                for(int i = 0; i < integers.size(); i++){
                    str += integers.get(i);
                    if(i == integers.size() - 1){
                        break;
                    }
                    str += " + ";
                }
                strings.add(str);
            }
            else {
                String str = n + " is NOT perfect.";
                strings.add(str);
            }
            integers.clear();

        }

        for(int i = 0; i < strings.size(); i++){
            bw.write(strings.get(i));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
