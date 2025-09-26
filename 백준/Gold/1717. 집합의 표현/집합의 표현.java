import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    static int[] arr;
    static int n, m;


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n + 1];

        ///  집합 생성
        ///  i = 0 ~ n 까지 해당 배열값은 루트 노드의 번호
        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            s = br.readLine().split(" ");


            ///  합친다.
            if(Integer.parseInt(s[0]) == 0){
                union(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            }

            /// 찾는다.
            if(Integer.parseInt(s[0]) == 1){
                int rtX = find(Integer.parseInt(s[1]));
                int rtY = find(Integer.parseInt(s[2]));

                if(rtX == rtY) {
                    sb.append("YES\n");
                }else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb);
    }

    ///  합집합 생성
    /// 루트 녿를 합침.
    static void union(int x, int y) {
        int rtX = find(x);
        int rtY = find(y);

        ///  부모노드가 다르다면 서로 다른 집합.
        ///  따라서 부모노드를 x로 두고합친다.
        if(rtX != rtY){
            arr[rtY] = rtX;
        }
    }


    static int find(int x){

        ///  부모노드가 다르다면 루트노드를 찾아 해당 루트노드로 배열의 밸류를 바꾼다.
        if(arr[x] != x){
            arr[x] = find(arr[x]);
        }
        return arr[x];
    }
}