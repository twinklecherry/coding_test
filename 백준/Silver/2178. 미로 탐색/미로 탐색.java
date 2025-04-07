import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        // 결과: (N-1, M-1) 위치의 값이 최단거리
        System.out.println(map[N-1][M-1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int nodeX = node[0];
            int nodeY = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = nodeX + dx[i];
                int ny = nodeY + dy[i];

                // 범위 확인
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 이동 가능한 칸 + 방문 안 한 경우
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[nodeX][nodeY] + 1; // 거리 누적
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}