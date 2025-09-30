import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s =br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = i;
        }

        for(int i = 0; i < m; i++){
            s = br.readLine().split(" ");
            int x =  Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            if(i == 0) {
                arr[x] = x;
                arr[y] = x;
                continue;
            }

            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                System.out.println(i + 1);
                return;
            } else {
                arr[rootY] = rootX;
            }

        }

        System.out.println("0");
    }


    static int find(int x){
        int root = x;
        if(arr[x] != x){

            root = find(arr[x]);
            arr[x] = root;
        }
        return root;
    }
}