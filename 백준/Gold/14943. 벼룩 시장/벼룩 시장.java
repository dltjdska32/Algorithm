import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

class Main{

    static int n;
    static int[] arr;
    static long ans = 0;
    static List<Integer> minusLoc = new ArrayList<>();
    static List<Integer> plusLoc =  new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");

        arr = new int[n + 1];

        for(int i = 0; i < s.length; i++)
        {

            arr[i] = Integer.parseInt(s[i]);

            if(arr[i] < 0){
                minusLoc.add(i);
            } else {
                plusLoc.add(i);
            }
        }

        while (true) {

            if(minusLoc.isEmpty() || plusLoc.isEmpty()) {
                break;
            }

            Integer pLoc = plusLoc.get(0);

            Integer mLoc = minusLoc.get(0);

            int dist = Math.abs(pLoc - mLoc);

            int pVal = arr[pLoc];
            int mVal = arr[mLoc];

            if(pVal < Math.abs(mVal)) {
                plusLoc = plusLoc.subList(1, plusLoc.size());
                arr[pLoc] = 0;
                arr[mLoc] = pVal + mVal;
                ans += dist * pVal;
            } else if (pVal >= Math.abs(mVal)){

                if(pVal == Math.abs(mVal)) {
                    plusLoc = plusLoc.subList(1, plusLoc.size());
                }

                minusLoc = minusLoc.subList(1, minusLoc.size());
                arr[mLoc] = 0;
                arr[pLoc] = pVal + mVal;
                ans += dist * Math.abs(mVal);
            }



        }


        System.out.println(ans);


    }
}