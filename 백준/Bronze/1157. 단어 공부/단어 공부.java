import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine().replace(" ", "").toUpperCase();
        char[] c = s.toCharArray();

        bw.write(String.valueOf(find(c)));

        bw.flush();
        bw.close();
    }

    public static char find(char[] c) {
        // c의 배역을 키값으로 두고 값이 중복되면 밸류값에 1증가된 값을 다시배치
        HashMap<Character, Integer> hashMap = new HashMap<>();

        //포이치문을 통해 배열 c 에서 중복된 값을 찾음
        for (char element : c) {

            //배열 c 에서 c의 값중 하나인 element와 중복된값이있다면 실행
            if (hashMap.containsKey(element)) {
                // 현재 element(c의 배열중 하나의값) 즉 키값과 매치되는 밸류(인트형값)을 cnt로 가져옴
                int cnt = hashMap.get(element);
                // 가져온 cnt값을 1증가시키고 해당 키값(element)과 같은 해쉬맵을 제거하고 해당 해쉬맵으로 재설정
                hashMap.put(element, cnt + 1);
            }
            // 배열 c에 c값중하나임 element와 중복된 값이 없다면 실행
            else {
                // 해쉬맵에 해당 키값을 가지는 것이 없으므로 해쉬맵에 해당키값과 1을 추가
                hashMap.put(element, 1);
            }
        }


        // 제일 큰 밸류를 가지는 키값(c)의 값을 찾기위한 알고리즘.
        char maxChar = ' ';
        //맥스는 인티저중 최소값 -2,147,483,648
        int max = Integer.MIN_VALUE;

        boolean b = false;

        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {


            // 해쉬맵의 밸류가 max보다 크다면 밸류의 해당 키값을 반환
            if (max < entry.getValue()) {

                max = entry.getValue();
                maxChar = entry.getKey();
                b = false;

            }
            //해쉬맵의 벨류에 max 값과 같은값이있다면 ?를반환
            else if (entry.getValue() == max) {
                b = true;
            }

        }

        if(b == true){
            return '?';
        }
        return maxChar;


    }



}



