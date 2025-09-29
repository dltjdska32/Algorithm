import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m;
    static int[] city;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        city = new int[n + 1];

        /// 루트 설정.
        for(int i = 1; i <= n; i++){
            city[i] = i;
        }


        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");

            for(int j = 0; j < s.length; j++){
                /// 연결되어있을경우 루트를 작은것으로 합침.
                if(s[j].equals("1")){

                    union(i + 1, j + 1);
                }
            }
        }

        String[] s = br.readLine().split(" ");

        int checkRoot = 0;

        for(int i = 0; i < s.length; i++){
            ///  첫번째 루트노드 확인.
            if( i == 0) {
                checkRoot = city[Integer.parseInt(s[i])];
                continue;
            }

            /// 첫번째 도시의 루트노드 값과 그이후 도시들의 루트노드값을 확인해서 값이 다르면 NO출력
            if(checkRoot !=  find(Integer.parseInt(s[i]))) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }


    static void union(int x, int y){
        ///  x의 루트노드번호
        int rootX = find(x);
        ///  y의 루트노트 번호
        int rootY = find(y);

        ///  루트가 다를경우 루트노드의 밸류를 작은루트로 통일
        if(rootX != rootY) {

            if(rootX < rootY){
                city[rootY] = rootX;
            } else {
                city[rootX] = rootY;
            }
        }
    }


    /// 자신들이 가리키고 있는 루트노드를 변경한다.
    static int find(int num){
        ///  다를경우 재귀호출을 하면서 root를 변경
        if(num != city[num]){
            city[num] = find(city[num]);
        }

        return city[num];
    }


}