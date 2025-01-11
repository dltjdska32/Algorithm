import java.io.*;
import java.util.*;
import java.lang.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int backNumber = -1;
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            String[] s = br.readLine().split(" ");

            if (s[0].equals("push")) {
                q.offer(Integer.parseInt(s[1]));
                backNumber = Integer.parseInt(s[1]);
                continue;
            }
            if (s[0].equals("pop")) {
                Integer poll = q.poll();
                if(poll != null) {
                    sb.append(poll).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
                continue;
            }
            if (s[0].equals("size")) {
                sb.append(q.size()).append("\n");
                continue;
            }
            if (s[0].equals("empty")) {
                if(q.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
                continue;
            }
            if (s[0].equals("front")) {
                Integer peek = q.peek();
                if(peek != null) {
                    sb.append(peek).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
                continue;
            }
            if (s[0].equals("back")) {
                if(q.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(backNumber).append("\n");

            }

        }

        System.out.println(sb);
    }
}