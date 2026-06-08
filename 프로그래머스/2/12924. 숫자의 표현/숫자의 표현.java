class Solution {
    public int solution(int n) {
         int answer = 0;

        int s = 0;
        int e = 1;

        int[] ori = new int[n+ 1];
        int[] arr = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            ori[i] = i;
        }

        for(int i = 1; i <= n; i++){
            arr[i] = arr[i - 1] + ori[i];

        }

        while(true) {

            int sum = arr[e] - arr[s];

            if(sum < n){
                e++;
            } else if(sum == n){
                e++;
                s++;
                answer++;
            } else if (sum > n){
                s++;
            }

            ///  e 위치 n보다 클경우 n으로고정
            if(e > n) {
                e = n;
            }

            ///  s 가 n보다 클경우 종료
            if(s == n){
                break;
            }

        }


        return answer;
    }
}