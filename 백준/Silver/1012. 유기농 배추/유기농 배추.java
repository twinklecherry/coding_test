import java.io.*;
import java.util.*;

public class Main {
    static int[][] field;     
    static boolean[][] visited; 
    static int M, N, K;     
    static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {-1, 1, 0, 0}; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); 

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken()); 

            field = new int[M][N];
            visited = new boolean[M][N];


            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            int wormCount = 0; 


            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j); 
                        wormCount++; 
                    }
                }
            }

            System.out.println(wormCount);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) { 
            int nx = x + dx[i];
            int ny = y + dy[i];


            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}