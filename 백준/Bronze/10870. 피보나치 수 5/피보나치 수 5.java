import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(fib(Integer.parseInt(br.readLine())));
    }

    public static int fib(int n) {
        if(n < 2) return n;

        return fib(n-1) + fib(n-2);
    }


    
}