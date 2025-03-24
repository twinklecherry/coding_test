import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 계단 개수
        int[] score = new int[N + 1]; // 각 계단의 점수
        int[] dp = new int[N + 1]; // 최대 점수를 저장할 DP 배열

        // 점수 입력
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 초기 조건
        dp[1] = score[1]; // 첫 번째 계단만 밟는 경우
        if (N >= 2) dp[2] = score[1] + score[2]; // 첫 번째, 두 번째 계단 밟는 경우
        if (N >= 3) dp[3] = Math.max(score[1] + score[3], score[2] + score[3]); // 첫 번째 or 두 번째 중 하나 선택

        // 점화식 적용
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }

        System.out.println(dp[N]); // 최댓값 출력
    }
}