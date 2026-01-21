import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

    static int n;
    static int r;
    static int q;

    static List<Integer>[] lst;
    static Map<Integer, Integer> size = new HashMap<>();


    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        q = Integer.parseInt(s[2]);

        lst = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++){
            lst[i] = new ArrayList<>();
        }


        for(int i = 1; i <= n - 1; i++){

            s = br.readLine().split(" ");

            int u =  Integer.parseInt(s[0]);
            int v =  Integer.parseInt(s[1]);

            lst[u].add(v);
            lst[v].add(u);

            size.put(i , 1);
        }

        size.put(n, 1);

        findNodeSize(r, r);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            int query = Integer.parseInt(br.readLine());
            sb.append(size.get(query)).append("\n");
        }

        System.out.println(sb.toString());

    }


    public static int findNodeSize(int curNod, int beforNod){

        List<Integer> child = lst[curNod];

        int cnt = 1;

        for(int i = 0; i < child.size(); i++){


            Integer childNod = child.get(i);

            if(childNod == beforNod){  /// 부모노드일경우 스킵
                continue;
            }

            int nodeSize = findNodeSize(childNod, curNod);

            /// 자식노드들의 사이즈를 더해줌.
            cnt += nodeSize;
        }

        size.put(curNod, cnt);

        return cnt;
    }

}