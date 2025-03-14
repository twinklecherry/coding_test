import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

class Main {
    static int N;
    static int[][] S;
    static boolean[] visited; 
    static int minDifference = Integer.MAX_VALUE; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //총인수
        S = new int[N][N];
        visited = new boolean[N];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹 시작
        divideTeam(0, 0);

        // 결과 출력
        System.out.println(minDifference);
    }

    // 백트래킹을 이용하여 N명을 두 팀으로 나누는 함수
    private static void divideTeam(int idx, int count) {
        // N/2명을 선택했을 때 팀을 나누고 능력치 계산
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        // 모든 경우의 수 탐색
        for (int i = idx; i < N; i++) {
            if (!visited[i]) { // 아직 선택되지 않은 사람이라면 선택
                visited[i] = true;
                divideTeam(i + 1, count + 1);
                visited[i] = false; // 원래 상태로 되돌리기 (백트래킹)
            }
        }
    }

    // 두 팀의 능력치 차이를 계산하는 함수
    private static void calculateDifference() {
        int startAbility = 0, linkAbility = 0;

        // 두 개의 팀을 나누기
        ArrayList<Integer> startTeam = new ArrayList<>();
        ArrayList<Integer> linkTeam = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (visited[i]) startTeam.add(i);
            else linkTeam.add(i);
        }

        // 능력치 계산
        for (int i = 0; i < N / 2; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                int startA = startTeam.get(i);
                int startB = startTeam.get(j);
                int linkA = linkTeam.get(i);
                int linkB = linkTeam.get(j);

                startAbility += S[startA][startB] + S[startB][startA];
                linkAbility += S[linkA][linkB] + S[linkB][linkA];
            }
        }

        // 최소 능력치 차이 갱신
        minDifference = Math.min(minDifference, Math.abs(startAbility - linkAbility));

        // 만약 차이가 0이면 더 이상 탐색할 필요 없음 (최소값)
        if (minDifference == 0) {
            System.out.println(0);
            System.exit(0);
        }
    }

}