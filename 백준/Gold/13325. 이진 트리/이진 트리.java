import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



/// 1. 누적값 max 구하기
/// 2. 리프노드들의 max - 누적값을 구한다.
/// 3. 리프노드부터 시작해서 형제노드의 max-누적값을 비교하면서 작은값을 상위 노드(의 간선)으로 올린다
///     (중요) 3 - 1. 형제 노드중 작은값(max-누적)을 가지는 간선(가중치)에 형제노드의 max-누적값(큰값) - 자신 (작은값)값을
///                    더해주면서 올라간다.
/// 4. 3 반복.
class Main{


    static int level;               //// 높이
    static int max = 0;             /// 최댓값
    static List<Node>[] tree;      //// 트리     높이는 1부터 시작 0빈값 , 각리스트는 0부터시작

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /// 높이
        int level = Integer.parseInt(br.readLine());
        setupTree(level);

        String[] s = br.readLine().split(" ");

        /// 2의 제곱으로 범위가 정해짐
        int target = 2;
        int start = 0;
        int curLevel = 1;
        /// 기본 트리 정보저장.
        setNodeInfo(s, curLevel, start, target);
        /// 형제노드 max 설정
        setMax(level);
        setBroNode(level);


        /// 리프의 forUpdateW 설정
        setLeafForUpdaeW(level);


        /// 리프부터 순회 하면서 curW변경
        updateNodesCurW(level);


        int ans = 0;

        /// 트리 순회하면서 ans 갱신
        ans = getAns(level, ans);


        System.out.println(ans);
    }

    private static void setMax(int level) {
        for(int i = 0; i < tree[level].size(); i++){
            ///  리프노드 순회하면서  누적가중치로 갱신

            Node node = tree[level].get(i);
            int sumW = node.sumW;

            max = Math.max(max, sumW);
        }
    }

    private static int getAns(int level, int ans) {
        for(int i = 1; i <= level; i++){


            List<Node> nodes = tree[i];

            for(int j = 0; j < nodes.size(); j++){

                Node node = nodes.get(j);

                ans += node.changedW;
            }
        }
        return ans;
    }

    private static void updateNodesCurW(int level) {
        for(int i = level; i >= 1; i--) {

            List<Node> nodes = tree[i];

            for(int j = 0; j < nodes.size(); j++) {

                Node node = nodes.get(j);
                node.changeValues();
            }
        }
    }


    private static void setLeafForUpdaeW(int level) {
        for(int i = 0; i < tree[level].size(); i++){

            Node node = tree[level].get(i);

            node.forUpdateW = max - node.sumW;
        }
    }


    private static void setBroNode(int level) {
        for(int i = 1; i <= level; i++){
            ///  높이 1부터가져온다.
            List<Node> nodes = tree[i];


            for(int j = 0; j < nodes.size(); j++){

                Node node = nodes.get(j);
                int curW = node.curW;

                /// i 홀수(노드 R) <-> i짝수(노드 L)
                if(j % 2 == 0){
                    ///  짝수일경우 형제노드 R값을 넣어줌.

                    Node rNode = nodes.get(j + 1);

                    node.setBro(rNode);


                } else {
                    ///  홀수일경우 형제노드 L값을 넣어줌.

                    Node lNode = nodes.get(j - 1);
                    node.setBro(lNode);
                }


                Node parent = node.parent;

                if(parent == null) continue;

                ///  생성 할때 누적가중치 만들었지만
                ///  혹시 몰라 다시 갱신
                int parentSumW = parent.sumW;
                node.sumW = curW + parentSumW;

            }

        }
    }

    private static void setNodeInfo(String[] s, int curLevel, int start, int target) {

        for(int i = 0; i  < s.length; i++){

            int w =  Integer.parseInt(s[i]);

            ///  높이가  1이면
            if(curLevel == 1){

                Node node = new Node();

                node.setParent(null);
                node.setCurW(w);
                node.setSumW(w);
                node.forUpdateW = 0;

                tree[curLevel].add(node);



                /// curLevel 갱신
                /// range갱신
                if(start == target - 1){
                    curLevel++;
                    start = 0;
                    target = (int) Math.pow(2, curLevel);
                    continue;
                }

                start++;


                continue;
            }


            ///  높이 2이상일경우
            Node node = new Node();

            node.setCurW(w);
            node.forUpdateW = 0;


            tree[curLevel].add(node);  /// 리스트에 넣어준다.
            node.setParent(tree[curLevel - 1].get(start / 2));  /// 넣어둔 객체의 부모노드 추가 (현재 리스트 길이  /  2 -> 부모 인덱스 번호.)
            node.setSumW(w + tree[curLevel - 1].get(start / 2).curW); /// 누적 가중치설정. w + 부모의 누적가중치



            /// curLevel 갱신
            /// range갱신
            if(start == target -1){
                curLevel++;
                start = 0;
                target = (int) Math.pow(2, curLevel);
                continue;
            }


            start++;
        }
    }


    private static void setupTree(int level) {
        tree = new List[level + 2];
        for(int i = 0; i <= level + 1; i++){
            tree[i] = new ArrayList<>();
        }
    }


    static class Node {
        Node bro;           ///형제노드
        Node parent;        ///부모노드
        int curW;           /// 기존 가중치
        int forUpdateW;     /// 간선 업데이트를 위한 값
        int sumW;
        int changedW;       ///변화된 값

        ///  ==========================================================================================///

        public void setBro(Node bro){
            this.bro = bro;
        }

        public void setParent(Node parent){
            this.parent = parent;
        }



        public void setCurW(int curW){
            this.curW = curW;
        }

        public void setSumW(int sumW){
            this.sumW = sumW;
        }


        ///  ==========================================================================================///


        ///  1. 리프노드는 max - sumW 해준다. 각각
        ///  2. 형제노드와 비고해서 max - sumW 가 작은값을 찾아낸다.
        ///  3. 작은값을 부모로 올린다.
        ///  4. 현재 간선을 갱신한다
        ///     -> 리프일 경우 : 현재간선 + (max - sum)  - 작은값
        ///     -> 리프가 아닐경우 : 올라온 간선의 값을 형제에 올라온 간선의 값과 비교한다.
        ///                         -> 두개를 비교해서 작은값을 부모로 올린다.
        ///                         -> 큰값을 가진 노드의 간선을 갱신한다. : 간선 + 큰값 - 작은값.
        public void changeValues(){


            this.changedW = this.curW;

            int forUpdateW = this.forUpdateW;
            int broForUpdateW = this.bro.forUpdateW;
            int minForUpdateW = Math.min(forUpdateW, broForUpdateW);

            if(forUpdateW > broForUpdateW){

                this.changedW = this.curW + forUpdateW - broForUpdateW;
            }

            if(parent != null){
                this.parent.forUpdateW = minForUpdateW;
            }

        }

    }
}