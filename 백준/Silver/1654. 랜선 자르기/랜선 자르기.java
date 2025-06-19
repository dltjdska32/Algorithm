import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        int j = 0;

        long answer = 0;
        long compareSize = 0;

        String[] str = br.readLine().split(" ");
        i = Integer.parseInt(str[0]);
        j = Integer.parseInt(str[1]);

        List<Long> sizeList = new ArrayList<>();

        for(int k = 0; k < i; k++){
            long size = Integer.parseInt(br.readLine());

            if(k == 0) {
                compareSize = size;
                sizeList.add(size);
                continue;
            }

            if(compareSize < size) {
                compareSize = size;
            }

            sizeList.add(size);
        }

        long low = 1;
        long high = compareSize;


        while(low <= high) {
            long mid = (low + high) / 2;
            long n = 0;

            for(int k = 0; k < sizeList.size(); k++){
                n += sizeList.get(k) / mid;
            }

            if(n >= j) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.print(answer);
    }
}