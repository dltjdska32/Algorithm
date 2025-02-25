import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       System.out.println(fact(Long.valueOf(br.readLine())));
    }

    public static Long fact(Long n) {
        if(n < 1) {
            return 1L;
        }
        return n * fact(n - 1);
    }
}