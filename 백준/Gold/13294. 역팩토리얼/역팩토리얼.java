import java.io.BufferedReader;
import java.io.InputStreamReader;

/// 역팩토리얼 (13294)

/// 로그를 통해서 자리수를 구해서 자리수로 팩토리얼을 찾는다. -> 10진수 - log10(n!)
///  ex) n이 5일경우 120 - 3자리수
///     ceil( log10(1) + log10(2) + log10(3) + log10(4) + log10(5)   )
///              0     +  약 0.3 +  약  0.5 +   약 0.6 +   약 0.7      =>  ceiling(2.~~) = 3
///   10의 거듭제곱일경우
///      ex) 100 일경우 log10(100) -> 2 + 1 해준다.
///  10!까지는 계산한 값으로 확인  300만
///  10!이상부터는 로그를 통해서 확인.
class Main{

    static final int MAX = 100000001;
    static double[] logVal = new double[MAX];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String q = br.readLine();

        int len = q.length();

        boolean isOver100Mil = len > 9;

        int under100MilVal = 1;

        ///  1이상일경우 자리수 비교
        ///  아닐경우 인트비교
        for(int i = 1; i <= MAX; i++){

            if(isOver100Mil){/// 자리수비교

                if(i == 1){
                    logVal[i] = 0.0;
                    continue;
                }

                double val = Math.log10(i);

                logVal[i] = logVal[i-1] + val;

                int compLen = (int) logVal[i] + 1;

                if(compLen == len){         /// 답찾으면 리턴
                    System.out.println(i);
                    return;
                }

            } else { ///  값비교

                under100MilVal *= i;

                if(under100MilVal == Integer.parseInt(q)){          /// 답찾으면 리턴
                    System.out.println(i);
                    return;
                }

            }


        }


    }
}