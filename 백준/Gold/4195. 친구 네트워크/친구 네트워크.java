import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int n, m;
    static Map<String, String> map;
    static int[] size;
    static int cnt = 1;
    static Map<String, Integer> checkSize;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++){
            m = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            size = new int[m + 1];
            checkSize = new HashMap<>();
            cnt = 1;
            for(int j = 0; j < m; j++){

                String[] s = br.readLine().split(" ");
                String friend1 = s[0];
                String friend2 = s[1];

                ///  첫번째 입력이거나 친구 1 2를 모두 포함하고잇지않을경우
                if(j == 0 || (!map.containsKey(friend1) && !map.containsKey(friend2))){
                    map.put(friend1, friend1);
                    map.put(friend2, friend1);
                    checkSize.put(friend1, 2);

                    System.out.println(checkSize.get(find(friend1)));
                    continue;
                }

                ///  둘다 포함할경우
                if(map.containsKey(friend1) && map.containsKey(friend2)){
                    union(friend1, friend2);
                    System.out.println(checkSize.get(find(friend1)));
                    continue;
                }

                ///  둘중 하나만 포함할 경우
                if(map.containsKey(friend1)){
                    String s1 = find(friend1);
                    map.put(friend2, s1);

                    Integer i1 = checkSize.get(s1);
                    checkSize.put(s1, i1 + 1);
                    System.out.println(checkSize.get(s1));
                    continue;
                }

                if(map.containsKey(friend2)){
                    String s2 = find(friend2);
                    map.put(friend1, s2);

                    Integer i2 = checkSize.get(s2);
                    checkSize.put(s2, i2 + 1);
                    System.out.println(checkSize.get(s2));
                }

            }

        }
    }

    static void union(String friend1, String friend2){
        String rootFriend1 = find(friend1);
        String rootFriend2 = find(friend2);

        if(!rootFriend1.equals(rootFriend2)){
            map.put(rootFriend2, rootFriend1);

            int size = checkSize.get(rootFriend1);
            size += checkSize.get(rootFriend2);
            checkSize.put(rootFriend1, size);
            checkSize.remove(rootFriend2);
        }
    }


    static String find(String friend){

        String result = friend;
        /// friend의 루트 노드 찾음.
        String root = map.get(friend);

        /// 루트가 friend와같지않을경우
        if(!root.equals(friend)){
            /// 루트를 찾는다.
            String s = find(root);
            result = s;
            ///  friend의 루트 변경
            map.put(friend, s);

        }
        return result;
    }
}