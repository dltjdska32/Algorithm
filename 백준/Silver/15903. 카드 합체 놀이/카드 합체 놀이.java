import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        PriorityQueue<Long> pq = new PriorityQueue<>();

        s = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            pq.add(Long.valueOf(s[i]));
        }

        for(int i = 0; i < m; i++){
            Long card1 = pq.poll();
            Long card2 = pq.poll();
            Long newCard = card1 + card2;
            pq.add(newCard);
            pq.add(newCard);
        }

        long ans = 0;
        while(!pq.isEmpty()){
            ans += pq.poll();
        }

        System.out.println(ans);
    }
}