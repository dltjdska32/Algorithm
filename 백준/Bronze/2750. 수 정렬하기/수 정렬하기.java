import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //선택정렬 O(N ^ 2)
        
        
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];


        int temp = 0;
        int min = 0;
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            array[i] = num;
        }


        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++) {
                if (array[i] > array[j]){
                    temp = array[i];
                    min  = array[j];

                    array[j] = temp;
                    array[i] = min;
                }
            }
        }


        for(int i = 0; i < N; i++){
            bw.write(String.valueOf(array[i]));
            bw.newLine();
         }

        bw.flush();
        bw.close();
    }
}

