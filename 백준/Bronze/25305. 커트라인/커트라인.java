    import java.io.*;
    import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int N = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] array = new int[N];

            String str = br.readLine();
            st = new StringTokenizer(str);
            for(int i = 0; i < N; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }


            int max = 0;
            int temp = 0;

            for(int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    if(array[i] <= array[j]){
                        max = array[j];
                        temp = array[i];

                        array[j] = temp;
                        array[i] = max;
                    }
                }
            }


            bw.write(String.valueOf(array[k - 1]));
            bw.flush();
            bw.close();
        }
    }
