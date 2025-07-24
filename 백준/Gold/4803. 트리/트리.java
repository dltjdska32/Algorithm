    import java.io.*;
    import java.util.*;



    public class Main {

        static int n;
        static int m;
        //노드 방문기록
        static boolean[] visited;
        // 간선인접리스트
        static List<Integer>[] link;
        // 트리 확인.
        static boolean checkCycle;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int testCaseNum = 1;

            while (true) {
                String[] s = br.readLine().split(" ");

                n = Integer.parseInt(s[0]);
                m = Integer.parseInt(s[1]);

                // n 과 m 이 0일경우 종료
                if(n == 0 && m == 0) break;

                // 노드의 링크를 생성할 인접리스트 생성
                link = new ArrayList[n + 1];
                visited = new boolean[n + 1];
                for(int i = 0; i <= n; i++){
                    link[i] = new ArrayList<>();
                }



                // 노드 간선 입력
                for(int i = 0; i < m; i++){
                    s = br.readLine().split(" ");

                    int node1 = Integer.parseInt(s[0]);
                    int node2 = Integer.parseInt(s[1]);

                    link[node1].add(node2);
                    link[node2].add(node1);

                }

                int cnt = 0;
                // 각 노드를 dfs를 통해 순회한다.
                for(int i = 1; i < link.length; i++){

                    // 만약 방문기록이 있으면 스킵
                    // 방문기록이 있다면 그래프든 트리든 연결되어 있는거기때문에
                    // 이미 카운트한 것
                    if(visited[i]) continue;
                    // checkTree 설정.
                    checkCycle = false;

                    // i (node) 방문
                    visited[i] = true;

                    dfs(i, i);

                    // checkTree가 true라는 것은 순환구조가 있다는것 따라서 tree가 아님 스킵해준다.
                    if(checkCycle) continue;

                    // 최종적으로 checkTree가 false일경우 cnt를 1증가시킨다.
                    cnt++;
                }



                if(cnt == 0) {
                    System.out.println("Case " + testCaseNum + ": No trees.");
                }
                if(cnt == 1){
                    System.out.println("Case " + testCaseNum + ": There is one tree.");
                }
                if(cnt > 1) {
                    System.out.println("Case " + testCaseNum + ": A forest of " + cnt + " trees.");
                }

                testCaseNum++;
            }
        }

        /*
        * idx - 간선을 확인할 노드
        * compIdx = dfs를 호출한 노드 번호 -> 양방향으로 설정했기때문에 호출한 노드와의 관계를 스킵하기위해
        * */
        static void dfs(int idx, int compIdx) {

            List<Integer> lst = link[idx];

            // 비어있을경우 종료
            if(lst.isEmpty()) return;

            // 만약 visited 방문기록이 있는곳을 다시방문할경우 tree x -> true반환
            for(int i = 0; i < lst.size(); i++){


                int node = lst.get(i);

                // 양방향설정을했기때문에
                // 만약 노드와 호출한노드가같다면 스킵
                if(node == compIdx) continue;

                // 방문기록이있을경우 checkTree를 true로 설정후 스킵
                if(visited[node]) {
                    checkCycle = true;
                    continue;
                }

                visited[node] = true;

                dfs(node, idx);
            }
        }
    }