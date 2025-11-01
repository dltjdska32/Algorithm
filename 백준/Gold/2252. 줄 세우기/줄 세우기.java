import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m;
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        Map<Integer, Node> map = new HashMap<>();

        for(int i = 0; i < m; i++){

            s = br.readLine().split(" ");

            int prev =  Integer.parseInt(s[0]);
            int next = Integer.parseInt(s[1]);

            ///  둘다 없을경우
            if(!map.containsKey(prev) && !map.containsKey(next)){
                Node prevNode = new Node(prev);
                Node nextNode = new Node(next);

                prevNode.addNextNode(nextNode);

                map.put(prev, prevNode);
                map.put(next, nextNode);
                continue;
            }

            /// 둘다 있을경우
            if(map.containsKey(prev) && map.containsKey(next)){
                Node prevNode = map.get(prev);
                Node nextNode = map.get(next);
                prevNode.addNextNode(nextNode);
                map.put(prev, prevNode);
                continue;
            }

            /// prev가 없고 next 존재할경우
            if(!map.containsKey(prev) && map.containsKey(next)){
                Node prevNode = new Node(prev);
                Node nextNode = map.get(next);
                prevNode.addNextNode(nextNode);
                map.put(prev, prevNode);
                continue;
            }

            ///  next가 없고, prev가있을경우
            if(map.containsKey(prev) && !map.containsKey(next)){
                Node nextNode = new Node(next);
                Node prevNode = map.get(prev);
                prevNode.addNextNode(nextNode);
                map.put(next, nextNode);
                continue;
            }
        }



        for(int i = 1; i <= n; i++){

            ///  n이 맵에 없을경우 큐에추가
            if(!map.containsKey(i)){
                q.add(new Node(i));
                continue;
            }

            ///  맵에 사이즈가 0이면
            if(map.get(i).prevNodeSize == 0){
                q.add(map.get(i));
            }

        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){

            Node poll = q.poll();
            poll.deleteNodes();
            sb.append(poll.num + " ");
        }

        System.out.println(sb.toString());
    }


    static class Node {
        int num;
        List<Node> nextNodes;
        int prevNodeSize;
        Node(int num) {
            this.num = num;
            prevNodeSize = 0;
            nextNodes = new ArrayList<>();
        }

        public void addNextNode(Node node){
            nextNodes.add(node);
            node.prevNodeSize++;
        }

        public void deleteNodes (){
            for (Node nextNode : nextNodes) {
                nextNode.prevNodeSize--;


                ///  연결된 이전간선이없으면 큐에 추가
                if(nextNode.prevNodeSize == 0){
                    q.add(nextNode);
                }
            }
        }
    }
}