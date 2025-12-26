import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/// 5 3
/// 1 2 3 1 2
/// 누적합을 통해 계산
///
/// # 10986 (나머지 합)
///
/// ## 문제
///
/// 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
///
/// 즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
///
/// ## 입력
///
/// 첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
///
/// 둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
///
/// ## 예시
///
/// ```
/// 5 3
/// 1 2 3 1 2
/// ```
///
/// 풀이법
///
/// - n^2이 나오면 안된다.
/// - 2중 포문 dfs 불가
///
/// → 누적합
///
/// → 1. 주어진수  - 1, 2, 3, 1, 2
///
/// → 2. 누적합     - 1, 3, 6, 7, 9
///
/// → 3. 나머지     - 1, 0, 0 ,1 ,0
///
/// → 봐야할것은 나머지
///
/// → 나머지가 같은것 2개를 하나의 쌍으로 묶을경우 결국 나머지는 0
///
/// → ex) 나머지가 1인것을 볼경우 → [1, 2, 3, 1] (나머지 3인덱스) - [1] (나머지 1인덱스) 일경우 [2 , 3, 1] 이것은 결국  나머지가 0이다
///
/// → 조합은 나머지가 0인것 , 2개를 하나로 묶은 쌍이 0이 나올경우 2가지로 나눠진다
///
/// → 이경우 예시에서는
///
/// 나머지 인덱스가 2, 3, 5  (0인 경우) 3가지
///
/// 나머지 인덱스 가 같은 쌍 (1, 4 인덱스) 1가지      →  나머지 1의 쌍
///
/// 나머지 인덱스가 같은 쌍 ([2,3] , [2,5], [3, 5])  3가지    →  나머지 0 의쌍
///
/// → 총 7가지가 나온다
///
/// → 나머지 그자체가 0 인경우 2 / 3 / 5 인덱스
///
/// → 나머지가 같은 인덱스 조합
///
/// **1. "개수만 센다" (나머지 카운팅)**
/// 컴퓨터는 인덱스가 몇 번인지, 어떤 쌍이 맺어지는지 궁금해하지 않습니다. 그냥 주머니에 나머지들을 담습니다.
/// • **나머지가 0인 주머니:** 3개 들어있음 (`2, 3, 5번 인덱스`) → `cnt[0] = 3`
/// • **나머지가 1인 주머니:** 2개 들어있음 (`1, 4번 인덱스`) → `cnt[1] = 2`
/// • **나머지가 2인 주머니:** 0개 들어있음 → `cnt[2] = 0`
/// **2. "수학 공식으로 정답을 한 번에 구한다"**
/// 조합을 일일이 매칭하지 않고, **주머니에 들어있는 개수**를 가지고 아래 공식을 씁니다.
/// **① 나머지가 0인 것들 처리**
/// 1. **그 자체로 정답인 경우:** 주머니에 3개 있으니까 그냥 **3**을 더합니다. (이게 인덱스 2, 3, 5 그 자체) → 3
/// 2. **자기들끼리 쌍을 맺는 경우:** 주머니에 3개 있으니까 3C2 공식을 씁니다. → 3
///
/// **② 나머지가 1인 것들 처리**
/// • **자기들끼리 쌍을 맺는 경우:** 주머니에 2개있으니까 2C2 공식을 씁니다. → 1
///
/// **3. 최종 계산 (이게 코드의 전부입니다)**
/// 3 + 3C2 + 2C2
public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /// 같은 나머지 찾기용 맵
        Map<Long, Long> modMap = new HashMap<>();

        String[] s =  br.readLine().split(" ");

        int n =  Integer.parseInt(s[0]);
        int m =  Integer.parseInt(s[1]);

        s = br.readLine().split(" ");


        Long sum = 0L;


        /// 각각의 모드를 맵에 넣어줌으로서 나머지의 똑같은 갯수를 찾아낸다.
        for(int i = 0; i < n; i++) {


            Long value =  Long.valueOf(s[i]);

            ///  누적합
            sum += value;

            /// 나머지
            Long mod = (sum % m) ;

            if(modMap.containsKey(mod)) {

                modMap.put(mod, modMap.get(mod) + 1);

            } else {

                modMap.put(mod, 1L);
            }

        }

        ///  나머지 0 ~ m -1 까지의 나머지 들을 찾는다.
        Long ans = 0L;

        for(Long l = 0L; l < m; l++){

            Long modCount = modMap.get(l);

            if(modCount == null){
                continue;
            }


            ///  나머지 0인것 따로 저장
            if(l == 0){
                ans += modCount;
            }

            Long retVal = calculateCombination(modCount);

            ans += retVal;
        }

        System.out.println(ans);

    }


    ///  C갯수중 2개의 조합을 계산
    public static Long calculateCombination(Long c) {

        if (c < 2) return 0L;

        return (c * (c - 1)) / 2;
    }


}