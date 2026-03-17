import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    static int n;
    static int min = 1000000000;
    static Map<Integer, Info> val = new HashMap<>();
    static boolean[] areaVal;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);

        s = br.readLine().split(" ");

        for(int  i= 1; i <= n; i++){
            Info info = new Info(Integer.parseInt(s[i -1]) , i);
            val.put(i, info);
        }


        for(int i = 1; i <= n; i++){
            s = br.readLine().split(" ");
            Info info = val.get(i);
            List<Info> linkedInfos = info.linkedInfos;
            /// 첫번째 글자 제외
            for(int j = 1; j < s.length; j++){

                int nodNum = Integer.parseInt(s[j]);

                linkedInfos.add(val.get(nodNum));
            }

            val.put(i, info);
        }


        /// 구역 설정
        areaVal = new boolean[val.size()+1];
        findAns(1);

        if(min == 1000000000) {
            System.out.println(-1);
            return ;
        }

        System.out.println(min);

    }

    private static void findAns(int cur) {

        ///현재 범위가 n보다 커질경우 구역이 제대로 나눠졌는지 확인
        if (cur == n + 1) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            int aVal = 0;
            int bVal = 0;

            ///  구역 나누기
            for(int i = 1; i <= n; i++){

                if(areaVal[i]) {
                    a.add(i);
                    aVal += val.get(i).popul;
                } else {
                    b.add(i);
                    bVal += val.get(i).popul;
                }

            }


            /// 팀이 나눠지지않았을경우
            if(a.size() == n || a.isEmpty()) {
                return;
            }

            // a팀 연결되어있는지 확인.
            Queue<Integer> q = new LinkedList<>();

            boolean[]  isVisited =  new boolean[val.size() + 1];
            Integer startA = a.get(0);
            q.add(startA);
            int cnt = 1;

            while(!q.isEmpty()){

                Integer poll = q.poll();

                isVisited[poll] = true;

                List<Info> friends = val.get(poll).linkedInfos;

                for (Info friend : friends) {

                    int friendId = friend.id;

                    if(a.contains(friendId) && !isVisited[friendId]){
                        isVisited[friendId] = true;
                        q.add(friendId);
                        cnt++;
                    }
                }
            }

            ///  a팀과 cnt가같지않으면 연결안됨.
            if(cnt != a.size()) {
                return;
            }

            // b팀 연결되어있는지 확인.
            q = new LinkedList<>();

            isVisited =  new boolean[val.size() + 1];
            Integer startB = b.get(0);
            q.add(startB);
            cnt = 1;

            while(!q.isEmpty()){

                Integer poll = q.poll();

                isVisited[poll] = true;

                List<Info> friends = val.get(poll).linkedInfos;

                for (Info friend : friends) {

                    int friendId = friend.id;

                    if(b.contains(friendId) && !isVisited[friendId]){
                        isVisited[friendId] = true;
                        q.add(friendId);
                        cnt++;
                    }
                }
            }

            ///  b팀과 cnt가같지않으면 연결안됨.
            if(cnt != b.size()) {
                return;
            }



            /// 최소값 계산
            int bestVal = Math.abs(aVal - bVal);

            min = Math.min(min, bestVal);


            return;
        }

        /// true a팀
        areaVal[cur] = true;
        findAns(cur + 1);

        /// false b팀
        areaVal[cur] = false;
        findAns(cur + 1);
    }


    static class Info{
        int id;
        int popul;
        List<Info> linkedInfos;

        public Info (int p, int id) {
            this.id = id;
            popul = p;
            linkedInfos = new ArrayList<>();
        }
    }
}