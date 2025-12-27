import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

///  홍익 투어
///
///
/// 트리맵 2개를 생성
/// 트리맵 1 -> 포인트 x
/// 트리맵 2 -> 포인트 o
///
///
/// 1. 입력값 분류
///  - 0 인것은 트리맵 1에 저장
///  - 1  인것은 트리맵 2에 저장
///
/// 2. 입력값마다 로직 수행
///  - 1 -> 명소 지정 해재
///      -> 명소 지정일경우 point 에 넣어주고 notPoint에서 제거 or point에서 제거 notpoints에 넣어줌
///
///  - 2 -> 무브 curLoc을 이동
///
///  - 3 -> 가장 가까운 위치거리 출력
///      -> curLoc을 가져와서 현재위치에서 가장 크거나 작은값을 notPoints에서 가져옴
///      -> 만약 없으면 제일 작은값을 가져와서 거리 계산
///
///
public class Main {


    public static void main(String[] args) throws Exception {

        /// firstKey()	가장 작은(첫 번째) 키를 반환	-
        /// lastKey()	가장 큰(마지막) 키를 반환	-
        /// lowerKey(K key)	인자보다 작은 키 중 최대값	<
        /// floorKey(K key)	인자와 같거나 작은 키 중 최대값	<=
        /// ceilingKey(K key)	인자와 같거나 큰 키 중 최소값	>=
        /// higherKey(K key)	인자보다 큰 키 중 최소값	>

        TreeMap<Integer,Integer> notPoints = new TreeMap<>();
        TreeMap<Integer,Integer> points = new TreeMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);

        s =  br.readLine().split(" ");

        for (int i = 0; i < n; i++) {

            int val =  Integer.parseInt(s[i]);

            if(val == 0) {
                notPoints.put(i + 1 ,0);
            }

            if(val == 1) {
                points.put(i + 1, 1);
            }

        }

        int totalSize = notPoints.size() + points.size();

        int curLoc = 1;


        for(int i = 0; i < q; i++) {

            s = br.readLine().split(" ");

            Integer num1 =  Integer.parseInt(s[0]);


            /// num2 구역 명소 지정 . 해제 .
            if(num1.equals(1)){
                Integer num2 = Integer.parseInt(s[1]);

                ///  명소에 있음 해제
                if(points.containsKey(num2)){

                    points.remove(num2);
                    notPoints.put(num2, 0);
                } else {
                    ///  명소에 없음 명소 지정

                    notPoints.remove(num2);
                    points.put(num2, 1);

                }

            }

            /// num2만큼 이동.
            if(num1.equals(2)){
                Integer num2 = Integer.parseInt(s[1]);

                int move = num2 % totalSize;

                curLoc += move;

                if(curLoc > totalSize){
                    curLoc -= totalSize;
                }
            }

            ///  명소까지거리
            if (num1.equals(3)){

                /// 만약 포인트가 없으면 -1출력
                if(points.isEmpty()){
                    System.out.println(-1);
                    continue;
                }

                /// 명소에서 현재위치보다 크거나 같은것중 가장 작은 값을 가져온다.
                Integer pointLoc = points.ceilingKey(curLoc);

                /// 현재 위치보다 큰 값이 없을경우 제일 작은 위치 확인
                if(pointLoc == null){

                    Integer minPoint = points.firstKey();

                    int distance = totalSize - curLoc + minPoint;

                    System.out.println(distance);

                    continue;
                }

                System.out.println(pointLoc - curLoc);
            }

        }


    }




}