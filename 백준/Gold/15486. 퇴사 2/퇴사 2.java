import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] Ti = new int[N+1];
        int[] Pi = new int[N+1];
        int[] dp = new int[N+2];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Ti[i] = Integer.parseInt(st.nextToken());
            Pi[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>=1; i--){
            dp[i] = Math.max(dp[i], dp[i+1]);

            if(i+Ti[i]<=N+1){
                dp[i] = Math.max(dp[i], Pi[i]+dp[i+Ti[i]]);

                if(i+Ti[i] <= N+1){
                    dp[i] = Math.max(dp[i], Pi[i]+dp[i+Ti[i]]);
                }
            }
        }
        System.out.println(dp[1]);
    }
}