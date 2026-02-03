import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main{

    static int n;

    static List<Info> lst = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        createMoveLog(n, 1, 2, 3);

        StringBuilder sb = new StringBuilder();
        sb.append(lst.size() + "\n");
        for(int i = 0; i < lst.size(); i++){
            Info info = lst.get(i);

            sb.append(info.s + " " + info.e + "\n");
        }
        System.out.println(sb);
    }


    static void createMoveLog(int n, int s, int tmp, int e) {

        /// n이 1개만 남았을경우 최종적으로 움직인 위치를 찍어준다
        if(n == 1){
            Info info = new Info(s, e);
            lst.add(info);
            return;
        }

        ///  제일 큰놈 제외 모두 보조 기둥으로 옮긴다.
        ///  시작지점 -> e를 거쳐 -> tmp로 가야함.
        createMoveLog(n - 1, s, e, tmp);

        /// 제일큰놈 출력 시작지점 -> e목표지점 바로 출력
        Info info = new Info(s, e);
        lst.add(info);

        ///  보조기둥에 있던 놈들 최종위치로 옮긴다.
        ///  tmp -> s 거쳐 -> e로 이동
        createMoveLog(n - 1, tmp, s, e);
    }


    static class Info{
        int s;
        int e;
        public Info (int s, int e){

            this.s = s;
            this.e= e;
        }


    }
}


