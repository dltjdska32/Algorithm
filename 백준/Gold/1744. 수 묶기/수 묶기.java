import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {

    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> plus = new PriorityQueue<>(
                (x, y) -> {
                    return y.compareTo(x);
                }
        );

        Queue<Long> one = new LinkedList<>();
        Queue<Long> zero = new LinkedList<>();

        PriorityQueue<Long> minus = new PriorityQueue<>();

        for(int i = 0; i < n; i++){

            Long x = Long.parseLong(br.readLine());

            if(x > 1){
                plus.add(x);
            } else if (x == 1){
                one.add(x);
            } else if(x == 0){
                zero.add(x);
            } else if(x < 0){

                minus.add(x);
            }
        }

        Long ans = 0L;

        if(zero.size() == 0){  /// 0 없을경우

            int check = 1;

            Long temp = 0L;

            ///  1제외 양수 묶으면서 더하기.
            while (!plus.isEmpty()){


                Long poll = plus.poll();

                if(check % 2 == 1){

                    temp += poll;
                    check++;

                } else if (check % 2 == 0){

                    temp *= poll;
                    ans += temp;
                    temp = 0L;
                    check = 1;
                }
            }

            ans += temp;


            ///  1값 더하기.
            while(!one.isEmpty()){
                Long poll = one.poll();
                ans += poll;
            }


            check = 1;

            temp = 0L;

            /// 음수값 * 면서 더하기
            while(!minus.isEmpty()){

                Long poll = minus.poll();

                if(check % 2 == 1){

                    temp += poll;
                    check++;

                } else if (check % 2 == 0){

                    temp *= poll;
                    ans += temp;
                    temp = 0L;
                    check = 1;
                }
            }

            ans += temp;


        } else if(zero.size() >= 1){  /// 0 있을경우


            int check = 1;

            Long temp = 0L;

            ///  1제외 양수 곱하면서 더하기.
            while (!plus.isEmpty()){


                Long poll = plus.poll();

                if(check % 2 == 1){

                    temp += poll;
                    check++;

                } else if (check % 2 == 0){

                    temp *= poll;
                    ans += temp;
                    temp = 0L;
                    check = 1;
                }
            }

            ans += temp;


            ///  1 더하기
            while(!one.isEmpty()){
                Long poll = one.poll();
                ans += poll;
            }

            check = 1;

            temp = 0L;


            if(minus.size() % 2 == 0) { /// - 가 짝수개

                while(!minus.isEmpty()){

                    Long poll = minus.poll();

                    if(check % 2 == 1){

                        temp += poll;
                        check++;

                    } else if (check % 2 == 0){

                        temp *= poll;
                        ans += temp;
                        temp = 0L;
                        check = 1;
                    }
                }

                ans += temp;

            } else { ///  - 가홀수개

                while(!minus.isEmpty()){

                    Long poll = minus.poll();

                    if(check % 2 == 1){

                        temp += poll;
                        check++;

                    } else if (check % 2 == 0){

                        temp *= poll;
                        ans += temp;
                        temp = 0L;
                        check = 1;
                    }
                }

                ans += temp * 0;

            }


        }


        System.out.println(ans);
    }
}