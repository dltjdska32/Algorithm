import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static int n = 0;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> primes;
        n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[n + 1];

        primes = makePrimeList(prime);

        int s = 0, e = 0;
        int tempSum = 0;
        int ans = 0;

        if(primes.size() == 0){
            System.out.println(0);
            return;
        }
        while (e <= primes.size()){

            if(e == 0){
                tempSum += primes.get(e);
                e++;
                continue;
            }

            if(tempSum == n){
                ans++;
                tempSum -= primes.get(s);
                s++;
                continue;
            }

            if(tempSum > n){
                tempSum -= primes.get(s);
                s++;
                continue;
            }

            if(tempSum < n){
                if(e >= primes.size()){ break;}
                tempSum += primes.get(e);
                e++;
            }

        }

        System.out.println(ans);
    }

    public static List<Integer> makePrimeList(boolean[] prime){
        List<Integer> lst = new ArrayList<>();

        prime[0] = prime[1] = true;

        for(int i = 2; i <= n; i++){

            for(int j = i; j <= n / i; j++){
                if(prime[i * j]) continue;
                prime[i * j] = true;
            }
        }

        for(int i = 2; i <= n; i++){
            if(prime[i]) continue;
            lst.add(i);
        }

        return lst;
    }
}
