    import java.io.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            //선택정렬 O(N ^ 2)

            int[] array = new int[5];
            int s = 0;
            for(int i = 0; i < 5; i ++){
                int n = Integer.parseInt(br.readLine());
                array[i] = n;
                s += n;
            }

            int average = s / 5;


            int min = 0;
            int temp = 0;
            for(int i = 0; i < 5; i++){
                for(int j = i + 1; j < 5; j++){
                    if(array[i] >= array[j]){
                        min = array[j];
                        temp = array[i];

                        array[j] = temp;
                        array[i] = min;
                    }
                }
            }

            bw.write(String.valueOf(average));
            bw.newLine();
            bw.write(String.valueOf(array[2]));


            bw.flush();
            bw.close();
        }
    }

