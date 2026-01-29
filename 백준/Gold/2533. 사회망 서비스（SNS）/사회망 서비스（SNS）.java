import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/// 사회망 서비스(SNS)
/// 최소의 얼리어 답터를 만들기 위해서는
/// 얼리어 답터를 부모로 올려야한다.
/// 리프는 얼리어 답터가 될수 없다.
///  트리 구조상 상위 높이 노드로 갈수록 노드의 수는 자식노드보다 작거나 같아진다.
///  무조건 얼리어 답터는 부모가 되어야한다.
///   1. 내 자식이 모두 얼리어 답터일경우 나는 얼리어 답터가 아니다.
///   2. 만약 내 자식중에 하나가 일리어 답터일경우  - 나는 얼리어답터
///   3. 만약 내자식중에 모두다 얼리어 답터가 아닐경우  - 나는 얼리어 답터
class Main{

    static int n;

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Integer> adaptMap = new HashMap<>();

    static int ans = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        /// 그래프 생성
        createGraph(br);


        findAns(1, 1);

        System.out.println(ans);
    }

    /// true 일경우 얼리어답터
    /// false 일경우 얼리어답터 x
    private static boolean findAns(int curNode, int parentNode) {

        List<Integer> childList = graph.get(curNode);

        int parentCount = 0;

        int childAdapterCount = 0;

        for(int i = 0; i < childList.size(); i++){

            int child = childList.get(i);

            ///  자식과 부모가 같으면 스킵
            if(child == parentNode){
                parentCount++;
                continue;
            }

            boolean isChildAdapter = findAns(child, curNode);

            /// 자식이 어댑터일경우
            if(isChildAdapter){
                childAdapterCount++;
            }


        }

        /// 리프 노드일경우 얼리어 답터 아님.
        if(parentCount == childList.size()){
            return false;
        }


        /// 자식이 모두 어답터일경우
        if(childAdapterCount == childList.size() - parentCount) {
            return false;
        }


        /// 나는 얼리어답터 ans++
        ans++;
        return true;
    }

    private static void createGraph(BufferedReader br) throws IOException {
        for(int i = 0; i < n - 1; i ++){

            String[] s = br.readLine().split(" ");

            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);

            if(graph.containsKey(u)){
                List<Integer> nodes = graph.get(u);
                nodes.add(v);
                graph.put(u, nodes);

            } else {

                List<Integer> nodes = new ArrayList<>();
                nodes.add(v);
                graph.put(u, nodes);
            }

            if(graph.containsKey(v)){

                List<Integer> nodes = graph.get(v);
                nodes.add(u);
                graph.put(v, nodes);

            } else {

                List<Integer> nodes = new ArrayList<>();
                nodes.add(u);
                graph.put(v, nodes);
            }
        }
    }
    
}