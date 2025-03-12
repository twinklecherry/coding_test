import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[5][5]; // 빙고판
        Map<Integer, int[]> numPos = new HashMap<>(); // 숫자 위치 저장 (숫자 -> 좌표)

        // 빙고판 입력받고, 숫자별 위치 저장
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                numPos.put(num, new int[]{i, j});
            }
        }

        // 사회자가 부르는 숫자 처리
        int callCount = 0; // 몇 번째 숫자인지
        int bingoCount = 0; // 빙고 개수

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                callCount++; // 숫자 부른 횟수 증가
                int callNum = Integer.parseInt(st.nextToken());

                // 해당 숫자의 위치 찾고 0으로 변경
                int[] pos = numPos.get(callNum);
                int row = pos[0];
                int col = pos[1];
                board[row][col] = 0;

                // 빙고 체크
                if (checkBingo(board) >= 3) {
                    System.out.println(callCount);
                    return; // 즉시 종료
                }
            }
        }
    }

    // 빙고 개수를 확인하는 함수
    private static int checkBingo(int[][] board) {
        int count = 0;

        // 가로 & 세로 검사
        for (int i = 0; i < 5; i++) {
            if (isBingo(board[i])) count++; // 가로
            if (isBingo(new int[]{board[0][i], board[1][i], board[2][i], board[3][i], board[4][i]})) count++; // 세로
        }

        // 대각선 검사
        if (isBingo(new int[]{board[0][0], board[1][1], board[2][2], board[3][3], board[4][4]})) count++; // 왼쪽 대각선
        if (isBingo(new int[]{board[0][4], board[1][3], board[2][2], board[3][1], board[4][0]})) count++; // 오른쪽 대각선

        return count;
    }

    // 한 줄이 빙고인지 확인하는 함수
    private static boolean isBingo(int[] line) {
        for (int num : line) {
            if (num != 0) return false;
        }
        return true;
    }
}