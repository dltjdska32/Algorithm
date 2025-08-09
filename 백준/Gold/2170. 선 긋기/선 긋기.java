import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<LineInfo> lst = new ArrayList<>();

        List<List<LineInfo>> lineInfos = new ArrayList<>();

        for(int i = 0; i< n; i++){
            String[] s = br.readLine().split(" ");
            LineInfo lineInfo = new LineInfo(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
            lst.add(lineInfo);
        }

        lst.sort((a, b) -> {
            if(a.start == b.start){
                return a.gap - b.gap;
            }
            return a.start - b.start;
        });


        int ans = 0;
        for(int i = 0; i< lst.size(); i++){
            ///  i가 첫번째일경우
            ///  ans에 첫번째에는 lineInfo.gap을 바로더해줌.
            if(i == 0){
                ans += lst.get(i).gap;
                continue;
            }

            ///  i 가 첫번째 이후일경우
            ///  비교를 해가면서 허대준다.
            if(i > 0){

                /// 현재선의 end가 이전선의 end보다 짧을경우 바로 continue;
                if(lst.get(i - 1).end >= lst.get(i).end){
                    ///  현재선의 end를 이전선의 end로 바꿔준다.
                    lst.get(i).end = lst.get(i - 1).end;
                    continue;
                }

                ///  이전 선의 end가 현재선의 start보다 크거나 같을경우
                ///  이전 선의 end와 현재 선의 end차를 ans에 더해준다.
                if(lst.get(i - 1).end >= lst.get(i).start){
                    int beforeEnd = lst.get(i - 1).end;
                    int currentEnd = lst.get(i).end;
                    ans += currentEnd - beforeEnd;
                    continue;
                }
                 ///  만약 이전 선의 end가 현재선의start보다 작으면
                ///  ans 에 현재선의 gap을 바로더해준다.
                if(lst.get(i - 1).end < lst.get(i).start){
                    ans += lst.get(i).gap;
                }
            }
        }

        System.out.println(ans);
    }

    static class LineInfo{
        int start;
        int end;
        int gap;

        public LineInfo(int start, int end){
            this.start = start;
            this.end = end;
            this.gap = end - start;
        }
    }
}



