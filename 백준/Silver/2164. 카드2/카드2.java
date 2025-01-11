import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        int cnt = 1;
        for(int i = 1; i <= n; i++){
            q.offer(i);
        }



        while(q.size() > 1) {
            if(cnt % 2 == 1) {
                q.poll();
            } else {
                q.offer(q.poll());
            }
            cnt++;
        }
        
        System.out.println(q.poll());
    }
}