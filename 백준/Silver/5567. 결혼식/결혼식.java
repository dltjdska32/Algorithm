import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main{

    // 노드
    static int n;
    // 간선
    static int m;
    static int cnt;
    // 방문 기록
    static boolean[] visited;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        // a를 키로하는 맵을 만든다 - key -> a , value -> b의 리스트
        for(int i = 0; i < m; i++){

            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            // 양방향으로 넣어주고 visit을 통해 검사한다.
            if(!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
            if(!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
        }

        // map에 1이없다면 0출력후 종료
        if(!map.containsKey(1)){
            System.out.println(0);
            return;
        }

        List<Integer> integers = map.get(1);

        //최대 뎁스 2 친구의 친구 따라서 2중for문 돌림.
        for(int i : integers) {


            //키값이없으면 스킵
            if(!map.containsKey(i)) continue;
            for (Integer integer : map.get(i)) {
                // 1 제외
                if(integer == 1) continue;
                //방문했으면 스킵
                if(visited[integer]) continue;
                visited[integer] = true;
                cnt++;
            }
            //방문했으면 스킵
            if(visited[i]) continue;
            visited[i] = true;
            cnt++;
        }

        System.out.println(cnt);
    }



}

