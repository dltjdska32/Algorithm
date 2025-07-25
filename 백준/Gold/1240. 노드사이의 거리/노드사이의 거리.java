    import java.io.*;
    import java.util.*;



    public class Main {

        ///  Tree 객체 (연결된 노드, 연결된 노드까지의 거리)
        ///  trees 인접리스트 0 ~ n (노드의 갯수) 까지 인접리스트를 만듦.
        ///  trees[0] 의 경우 ArrayList가 들어있다.
        ///  trees의 각방은 노드의 번호이다.
        ///  trees의 각방에는 연결된 노드의 정보(노드번호, 노드까지거리)
        ///  메인함수에서 startNode 와 endNode를 파라미터로 넣어주는 dfs함수를 실행한다.
        ///  dfs함수에서는 재귀호출을 진행하면서 startNode 부터 endNode를 찾아나간다.
        ///  endNode는 메인에서 입력하는값을 고정으로 넣어준다.

        // 노드 갯수
        static int n;
        // 출력 라인 갯수
        static int m;
        // 양방향 트리구현을 위한 인접리스트
        static List<NodeInfo>[] nodeInfos;

        static int distanceOfNodes;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] s = br.readLine().split(" ");

            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);


            // 양방향으로 트리 세팅
            nodeInfos = new List[n + 1];
            for(int i = 0; i <= n; i++){
                nodeInfos[i] = new ArrayList<>();
            }

            for(int i = 0; i < n - 1; i++) {

                s = br.readLine().split(" ");

                int node1 = Integer.parseInt(s[0]);
                int node2 = Integer.parseInt(s[1]);
                int distance = Integer.parseInt(s[2]);

                // 양방향으로 노드를 세팅한다.
                nodeInfos[node1].add(new NodeInfo(node2, distance));
                nodeInfos[node2].add(new NodeInfo(node1, distance));
            }

            StringBuilder sb = new StringBuilder();
            // 노드 사이의 거리 구하기.
            for(int i = 0; i < m; i++){
                s = br.readLine().split(" ");
                int node1 = Integer.parseInt(s[0]);
                int node2 = Integer.parseInt(s[1]);
                distanceOfNodes = 0;
                dfs(node1, node2, node1);
                sb.append(distanceOfNodes).append("\n");
            }

            System.out.println(sb);

        } //main


        // checkNode의경우 양방향으로설정된 노드의 시작노드를 확인하기 위한 파라미터
        static boolean dfs (int startNode, int endNode, int checkNode){

            // startNode 와 endNode가같다면 true반환후 종료
            if(startNode == endNode){
                return true;
            }

            boolean check = false;

            List<NodeInfo> parentsNodeInfo = nodeInfos[startNode];

            // 시작노드 부터 자식노드를 찾아가면서 dfs를 시작한다
            // endNode를 찾을경우 check를 true로 바꾸고
            // dfs가 true가되면 상위노드로 올라가면서 distanceOfNodes에 nodeInfo.distance를 더해준다.
            for(int i = 0; i < parentsNodeInfo.size(); i++){

                NodeInfo nodeInfo = parentsNodeInfo.get(i);

                // 양방향설정으로 checkNode와 nodeInfo의 linkedNode가 같다면 스킵
                if(checkNode == nodeInfo.linkedNode) continue;

                //dfs시작
                check = dfs(nodeInfo.linkedNode, endNode, startNode);

                //만약 dfs로 end노드를 찾았다면 true를 반환하면서 재귀호출이 종료되기 때문에
                // check가 true일경우 distanceOfNodes에 nodeInfo의 distance를 더해주면서 return한다
                if(check) {
                    distanceOfNodes += nodeInfo.distance;
                    return check;
                }
            }

            return check;
        } // dfs

    }

    class NodeInfo{
        int linkedNode;
        int distance;

        public NodeInfo(int linkedNode, int distance) {

            this.linkedNode = linkedNode;
            this.distance = distance;
        }
    }