import java.io.*;
import java.nio.IntBuffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 숫자 n 과 m 이 주어진다.
        // 1 ~ n 까지 포캣몬을 입력받고 키값에는 포켓몬 이름을 밸류값에는 입력받은 순서를 받아 해쉬맵을 만든다.
        // n번째줄 다음부터는 문제이다. 문제는 입력받은 순서번호를 입력할경우 해당 키값을 반환, 포켓몬 이름을 입력할경우 입력번호를 출력한다.
        // + 이 문제에서는 해쉬맵을 2가지 만든다.  HashMap <이름, 입력순서> hashmap 과 HashMap < 입력순서, 이름> hashmap1
        // 이렇게 하는 이유는 해쉬맵의 경우 키값을 받으면 해당 밸류를 출력하는 함수가 있지만 밸류값을 입력하면 해당 키값을 출력하는 함수가 없기때문에
        // entrySet() 함수를 사용하여 모든 해쉬맵을 순회하기 때문이다. 그렇게 된다면 m 번 * 해쉬맵 크기 만큼의 시간복잡도가 된다. 따라서 이렇게 할경우 시간복잡도가 높아져 시간초과가난다.
        // 해쉬맵을 2가지만든다면 시간복잡도는 o(1)이 된다.
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        //n과 m을 받는다
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 시간복잡도를 낮추기 위해 2개의 해쉬맵을 생성
        HashMap <String, Integer> hashMap = new HashMap<>();
        HashMap <Integer, String> hashMap1 = new HashMap<>();


        int cnt = 1;

        //hashmap에는 포켓몬이름을 입력하고 해쉬맵에 키값으로 저장하고, 밸류로는 입력 순서를 저장
        //hashmap1에는 키값으로 입력순서를, 밸류로는 포켓몬 이름을 저장한다.

        for(int i = 0; i < n; i++){
            String name = br.readLine();

            hashMap.put(name, cnt);
            hashMap1.put(cnt, name);

            cnt++;
        }

        // m번 반복하면서 문제의 정답을 찾는다.
        // 포켓몬 이름(키값)을 입력하면 입력순서(밸류값)을 출력하고, 입력순서(밸류값)을 입력하면 포켓몬 이름(키값)을 출력한다.
        
        // + 만약 해쉬맵을 하나만 만들게 된다면 해쉬맵의 키값을 출력하기 위해 entrySet()함수를 사용하여 해쉬맵 전체를 순회하여야한다. 
        // 이렇게 하면 이중 포문을 돌기때문에 시간복잡도가 높아진다. 
        for(int i = 0; i < m; i++){
            String str = br.readLine();

            //해쉬맵에 일치하는 포켓몬 이름 (키값)이 있을경우 밸류값을 출력
            if(hashMap.containsKey(str)){
                bw.write(String.valueOf(hashMap.get(str)));
                bw.newLine();
            } else if(hashMap1.containsKey(Integer.parseInt(str))) {
                    bw.write(hashMap1.get(Integer.parseInt(str)));
                    bw.newLine();
            }

        }

        bw.flush();
        bw.close();
    }



}
