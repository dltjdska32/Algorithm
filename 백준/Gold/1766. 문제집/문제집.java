import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m;

    ///  큐에 들어오면 번호순으로 정렬
    static Queue<Node> q = new PriorityQueue<>( (a, b) -> {
        return a.num - b.num;
    });
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        Map<Integer, Node> map = new HashMap<>();


        ///오름차순으로 쉬운문제순으로 값에 넣어준다.
        for(int i = 0; i < m; i++){
            s = br.readLine().split(" ");
            int cur =  Integer.parseInt(s[0]);
            int next = Integer.parseInt(s[1]);

            /// 둘다없음.
            if(!map.containsKey(cur) && !map.containsKey(next)){

                Node curNode = new Node(cur);
                Node nextNode = new Node(next);

                curNode.addNextNode(nextNode);
                nextNode.prevSize++;

                map.put(cur, curNode);
                map.put(next, nextNode);
                continue;
            }

            /// 둘다있음.
            if(map.containsKey(cur) && map.containsKey(next)){
                Node curNode = map.get(cur);
                Node nextNode = map.get(next);

                curNode.addNextNode(nextNode);
                nextNode.prevSize++;
                map.put(cur, curNode);
                map.put(next, nextNode);

                continue;
            }

            ///  cur만 있음
            if(map.containsKey(cur) && !map.containsKey(next)){
                Node curNode = map.get(cur);
                Node nextNode = new Node(next);

                curNode.addNextNode(nextNode);
                nextNode.prevSize++;
                map.put(cur, curNode);
                map.put(next, nextNode);

                continue;
            }

            ///  next만 있음
            if(!map.containsKey(cur) && map.containsKey(next)){
                Node nextNode = map.get(next);
                Node curNode = new Node(cur);

                curNode.addNextNode(nextNode);
                nextNode.prevSize++;
                map.put(cur, curNode);
                map.put(next, nextNode);

                continue;
            }
        }

        /// 쉬운순서대로 정렬되어있는 맵을 순회하면서 prevSize가 0인 값을 찾아
        ///  큐에 넣고 큐에들어간 노드와 연결된 다음노드들의prevSize를 --하면서 0일경우 또추가 반복
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){

            if(!map.containsKey(i)){
                sb.append(i + " ");
                continue;
            }

            if(map.get(i).prevSize == 0){
                q.add(map.get(i));
            }
            
        }


        while(!q.isEmpty()){

            Node poll = q.poll();

            poll.deleteNextNode();
            sb.append(poll.num + " ");
        }

        System.out.println(sb.toString());

    }


    static class Node {
        int num;
        int prevSize;
        List<Node> nextNodes;

        public Node(int num) {
            this.num = num;
            nextNodes = new ArrayList<>();
            prevSize = 0;

        }

        public void minusPrevSize() {
            prevSize--;
        }

        public void addNextNode(Node node) {
            nextNodes.add(node);
        }

        ///  prevSize --
        ///  --한 prevsize가 0일경우 큐에 넣음
        public void deleteNextNode() {
            for (Node nextNode : nextNodes) {
                nextNode.minusPrevSize();
                if(nextNode.prevSize == 0){
                    q.add(nextNode);
                }
            }
        }
    }
}