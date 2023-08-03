import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList < Integer > xs = new ArrayList < > ();
        ArrayList < Integer > ys = new ArrayList < > ();

        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int x = Integer.parseInt(st.nextToken());
            xs.add(x);

            int y = Integer.parseInt(st.nextToken());
            ys.add(y);

        }

        boolean b = false;
        for (int i = 0; i < xs.size(); i++) {
            for (int j = 0; j < xs.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (xs.get(i).equals(xs.get(j))) {
                    // 배열 순서에 맞게 배열에 맨뒤쪽에 있는 값부터 제거
                    if (i > j) {
                        xs.remove(i);
                        xs.remove(j);
                    } else {
                        xs.remove(j);
                        xs.remove(i);
                    }
                    b = true;
                    break;
                }
            }
            if (b) {
                b = false;
                break;
            }
        }

        for (int i = 0; i < ys.size(); i++) {
            for (int j = 0; j < ys.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (ys.get(i).equals(ys.get(j))) {
                    // 배열 순서에 맞게 배열 뒤쪽부터 제거
                    if (i > j) {
                        ys.remove(i);
                        ys.remove(j);
                    } else {
                        ys.remove(j);
                        ys.remove(i);
                    }

                    b = true;
                    break;
                }
            }
            if (b) {
                break;
            }
        }

        bw.write(xs.get(0) + " " + ys.get(0));



        bw.flush();
        bw.close();

    }

}