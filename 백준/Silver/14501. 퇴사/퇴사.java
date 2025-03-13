import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] Ti = new int[N+1]; //i번째 상담에 걸리는 시간
        int[] Pi = new int[N+1]; //i번째 상담에서 얻을 수 있는 최대 수익
        int[] dp = new int[N+2]; //i번째 날까지 진행했을때 얻을 수 있는 최대 수익
        
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Ti[i] = Integer.parseInt(st.nextToken());
            Pi[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=N; i>=1; i--){
            dp[i] = Math.max(dp[i], dp[i+1]);

            if(i+Ti[i]<=N+1){
                dp[i] = Math.max(dp[i], Pi[i]+dp[i+Ti[i]]);
            }
        }
            System.out.println(dp[1]);

    }
}