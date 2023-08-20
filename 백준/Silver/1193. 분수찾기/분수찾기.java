import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //분수찾기 문제
        //해당 문제는 x 의 값을 우선적으로 입력받는다.
        //그후 입력받은 x의 값이 위치한 라인을 찾는다 -> 라인의 값은 행의 값이된다. 
        // 해당 라인의 우측 상단값 (k) 좌측 하단값 (k1)이된다.
        // x의 값이 만약 1이라면  1/1 을 출력한다.
        // x의 값이 만약 1이상이고 x가 위치한 라인이 짝수라면 분모는 해당라인의 값(행의 값), 분자는 1이된다.
        // x의 값이 만약 1이상이고 x가 위치한 라인이 홀수라면 분모는 1, 분자는 해당라인의 값(행의 값) 이된다.
        
        //찾고있는 분수의 위치
        int x = Integer.parseInt(br.readLine());

        
        int k = 1;    //우측상단 번호
        int k1 = 1;   //좌측하단 번호

        int line = 0; //행의 번호


        for(int i = 1; i <= x; i++){
            //입력받은 x 가 1이라면 분모 분자 모두 1이므로 그냥 for문을 탈출
            if(x == 1){
                break;
            }
            
            
            // 입력받은 x 가 1 이상이라면 우측상단(행)의값은 k 값에 1 , 2, 3, 4 ...... 씩 더하면서 추가
            // 입력받은 x 가 1 이상이라면 좌측하단(열)의 값은 k1 값에 2 , 3, 4, 5, 6 .... 씩 더하면서 추가
            k += i;
            k1 += i + 1;
        
            // 만약 우측상단값(k) 와 좌측하단 (k1)의값 사이에 x 가있다면 행의 값을 구하고 for문 탈출
            if(x >= k && x <= k1){
                line = i + 1;
                break;
            }
        }

        //우측 상단(k) 에서 x 까지 가야할 거리
        int num = x - k;  

        // 만약 입력받은 x 가 1 일경우 바로 1/1 출력
        if(x == 1){
            bw.write("1/1");
        }
        // 만약 입력받은 x 가 1 보다 클경우 x 값 위치의 분수를 구하는 알고리즘
        else if(x > 1){
            
            // 우선 분자를 1로 두고 분모를 행의 값으로 둔다.
            int son = 1;
            int mom = line;

            //행의 값이 만약 짝수일경우 k값에서 x 위치까지 분자는 ++ , 분모는 -- 한다.
            if(line % 2 == 0) {
                if (num == 0) {
                    bw.write(String.valueOf(son) + "/" + String.valueOf(mom));
                } else if (num > 0) {
                    for (int i = 0; i < num; i++) {
                        son++;
                        mom--;
                    }
                    bw.write(String.valueOf(son) + "/" + String.valueOf(mom));
                }
            }
            
            // 행의 값이 홀수라면 행의값이 홀수인경우 분자와 분모의 값을 바꾼다.
            if(line % 2 == 1){
                if (num == 0) {
                    bw.write(String.valueOf(mom) + "/" + String.valueOf(son));
                } else if (num > 0) {
                    for (int i = 0; i < num; i++) {
                        son++;
                        mom--;
                    }
                    bw.write(String.valueOf(mom) + "/" + String.valueOf(son));
                }

            }
        }

        bw.flush();
        bw.close();
    }

}