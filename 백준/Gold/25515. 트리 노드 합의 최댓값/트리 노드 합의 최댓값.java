import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main{


    static int n = 0;
    static Node[] nodes;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);

        nodes = new Node[n + 1];

        for(int i = 0; i < n - 1; i++){

            s = br.readLine().split(" ");

            int p =  Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);

            if(nodes[p] == null){
                Node pNode = new Node(p);
                pNode.addChild(c);
                nodes[p] = pNode;
            } else {
                nodes[p].addChild(c);
            }

            if(nodes[c] == null){
                Node cNode = new Node(c);
                nodes[c] = cNode;
            }
        }

        s = br.readLine().split(" ");

        for(int i = 0; i < s.length; i++){

            Node node = nodes[i];

            node.addNum(Integer.parseInt(s[i]));
        }


        System.out.println(findAns(0));

    }

    private static Long findAns(int id) {

        Node node = nodes[id];

        List<Integer> children = node.children;


        Long curNum = Long.valueOf(node.num);

        ///  리프노드일경우 그냥 자신의 번호를 올림.
        if(children.size() == 0){
            return curNum;
        }

        ///  포문을 돌리면서 자식노드들을 방문하면서 올라온 번호와 현재 노드의 번호
        ///  합 크기를 비교하여 큰숫자를 정한다.
        for(int i = 0; i < children.size(); i++){

            Integer childrenId = children.get(i);

            Long childNum = findAns(childrenId);

            curNum = Math.max(curNum + childNum, curNum);
        }

        /// 만든 숫자중 제일 큰 숫자를 반환.
        return curNum;
    }


    static class Node {
        int id;
        int num;
        List<Integer> children;

        public Node(int id) {
           this.id  = id;
           this.children = new ArrayList<>();
        }

        public void addChild(int num){
            this.children.add(num);
        }

        public void addNum(int num){
            this.num = num;
        }
    }
}