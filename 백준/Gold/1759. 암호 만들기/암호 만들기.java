import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int l;
    static int c;
    static String[] str;
    static List<String> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        // 트리의 뎁스
        l = Integer.parseInt(s[0]);

        c = Integer.parseInt(s[1]);

        str = br.readLine().split(" ");
        Arrays.sort(str);

        //루트노드 순회
        for(int i = 0; i <= c - l; i++){
            ans.clear();
            ans.add(str[i]);
            //루트노드별 자식노드 순회
            bt(i + 1);
        }

    }


    //재귀호출은 최대 ans.size() 가 c 와같은때 까지만반복.
    public static void bt (int depth){

        int vwlCnt = 0;
        int consCnt = 0;

        // ans.size()가  l 과 같다면
        // 출력하고 종료하거나 그냥 종료
        // 종료시 vwlCnt , consCnt 0으로 초기화.
        if(ans.size() == l){


            for(int i = 0; i < ans.size(); i++){
                if(ans.get(i).equals("a")
                || ans.get(i).equals("e")
                || ans.get(i).equals("u")
                || ans.get(i).equals("i")
                || ans.get(i).equals("o")) {
                    vwlCnt++;
                } else {
                    consCnt++;
                }
            }

            // 모음 1 이상 자음2이상
            // 출력.
            if(vwlCnt > 0 && consCnt > 1){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < ans.size(); i++){
                    sb.append(ans.get(i));
                }
                System.out.println(sb);
            }

            return;
        }

        // 자식노드 호출
        // 순회 마지막일경우 ans의 마지막을 제거
        for(int i = depth; i < c; i++){

            //단어추가
            ans.add(str[i]);
            bt(i + 1);
            //마지막 단어 제거
            ans.remove(ans.size() -1);
        }
    }
}
