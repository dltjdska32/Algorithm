
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    // 사람수
    static int n;
    // 파티수
    static int m;

    // 진실을 아는 사람 
    static boolean[] visited;
    
    // 진실을 아는사람 양방향 리스트
    static List<Integer>[] truthList;

    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        visited = new boolean[n + 1];
        q = new LinkedList<>();

        s = br.readLine().split(" ");

        // 만약 진실을 아는 사람이없을경우 파티수 출력
        if(s[0].equals("0")) {
            System.out.println(m);
            return;
        }

        //진실을 아는사람 초기 세팅
        // q에 담아줌.
        for(int i = 1; i < s.length; i++){
            int num = Integer.parseInt(s[i]);

            visited[num] = true;
            q.offer(num);
        }

        List<List<Integer>> parties = new ArrayList<>();
        truthList = new List[n + 1];
        for(int i = 0; i <= n; i++){
            truthList[i] = new ArrayList<>();
        }

        //양방향 그래프세팅 및 파티 정보 저장.
        for(int i = 0; i < m; i++){
            s = br.readLine().split(" ");

            int num = Integer.parseInt(s[0]);

            // 1보다 클경우 양방향리스트 설정
            if(num > 1) {

                for(int j = 0; j < num - 1; j++){

                    for(int k = j + 1; k < num; k++){

                        int people1 = Integer.parseInt(s[j + 1]);
                        int people2 = Integer.parseInt(s[k + 1]);
                        truthList[people2].add(people1);
                        truthList[people1].add(people2);
                    }
                }
            }

            List<Integer> lst = new ArrayList<>();

            for(int j = 0; j < num; j++){
                lst.add(Integer.parseInt(s[j + 1]));
            }

            parties.add(lst);
        }

        // bfs 시작
        // 
        while (!q.isEmpty()){

            int num = q.poll();
            visited[num] = true;


            for (Integer i : truthList[num]) {

                if(visited[i]) continue;
                visited[i] = true;
                q.offer(i);
            }

        }

        int ans = m;
        
        //모든 파티를 순회
        // 파티원중 진실을 아는사람이 있으면
        // ans 에서 -1 -> 초기 ans = 파티숫자.
        for(int i = 0; i < parties.size(); i++){

            List<Integer> integers = parties.get(i);
            boolean check = false;
            for(int j = 0; j < integers.size(); j++){
                if(visited[integers.get(j)]) {
                    check = true;
                    break;
                }
            }

            if(check) {
                ans--;
            }
        }


        System.out.println(ans);
    }


}