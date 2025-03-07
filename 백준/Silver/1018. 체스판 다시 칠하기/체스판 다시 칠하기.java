import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.nextLine();

        char[][] board = new char[N][M];
        
        for(int i=0; i<N; i++){
            board[i] = sc.nextLine().toCharArray();
        }
        sc.close();

        int minRepaints = Integer.MAX_VALUE;
        // 8x8 체스판을 순회하며 최소 repaint 수 계산
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int repaint1 = 0, repaint2 = 0;
                char[] colors = {'W', 'B'};
                
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        // 첫 번째 체스판 색깔(W 기준)
                        if (board[i + k][j + l] != colors[(k + l) % 2]) repaint1++;
                        // 두 번째 체스판 색깔(B 기준)
                        if (board[i + k][j + l] != colors[1 - (k + l) % 2]) repaint2++;
                    }
                }
                minRepaints = Math.min(minRepaints, Math.min(repaint1, repaint2));
            }
        }
        
        System.out.println(minRepaints);
    }
}