import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {


    static class Loc {

        Long x;
        Long y;

        public Loc (Long x, Long y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /// x 오룸차순으로 정렬 만약 x가 같다면 y 내림차순 정렬
        PriorityQueue<Loc> seqLoc = new PriorityQueue<>((a, b) ->{

            if(a.x.equals(b.x)) return  b.y.compareTo(a.y);

            return a.x.compareTo(b.x);
        });


        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++){

            String[] s = br.readLine().split(" ");

            Loc loc = new Loc(Long.parseLong(s[0]), Long.parseLong(s[1]));

            seqLoc.add(loc);
        }



        Long ans = 0L;

        Long befX = 0L;
        Long befY = 0L;
        /// 우선순위 큐에 첫번째 꺼낸다
        Loc first = seqLoc.poll();

        Long firstY = first.y;
        Long firstX = first.x;
        befX = firstX;
        befY = firstY;

        ans = Math.abs(firstX-firstY);

        ///  q 빌때까지 반복
        while (!seqLoc.isEmpty()){

            Loc val = seqLoc.poll();

            Long curX = val.x;
            Long curY = val.y;

            /// y는 내림차순이기때문에 시작점이같으면 그냥 스킵
            if(befX.equals(curX)) continue;

            /// 이전 Y값이 현재 Y값보다 클경우 스킵
            if(befY > curY) continue;


            /// befX와 curX가 다른것은 시작점이 다르다는것
            /// 위에서 befX가 같으면 해당 로직을 안탄다
            ///  만약 befX가 다를경우
            ///  현재 X 와 이전 Y를 비교한다
            ///  이전 Y보다 현재 x위치가 더크다면 그냥 |x - y|
            ///  이전 Y 보다 현재 X가 더 작다면 |이전 Y - 현재 Y|

            if(curX > befY){  ///  현재 x 와 이전 Y가 한 선안에 있는경우 가아닐경우
                ans += Math.abs(curX - curY);
            } else { ///  현재 x와 이전 Y가 한선안에 있을경우
                ans += Math.abs(befY - curY);
            }



            /// befX 갱신 befY 갱신
            befX = curX;
            befY = curY;
        }

        System.out.println(ans);

    }


}