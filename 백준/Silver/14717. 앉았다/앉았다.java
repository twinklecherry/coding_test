import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.close();
        
        double winProbability = calculateWinProbability(A, B);
        System.out.printf("%.3f\n", winProbability);
    }
    
    public static double calculateWinProbability(int A, int B) {
        int[] deck = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10};
        
        // 영학이의 패를 제외한 덱 구성
        List<Integer> remainingDeck = new ArrayList<>();
        boolean usedOne = false, usedTwo = false;
        
        for (int card : deck) {
            if (card == A && !usedOne) {
                usedOne = true;
                continue;
            }
            if (card == B && !usedTwo) {
                usedTwo = true;
                continue;
            }
            remainingDeck.add(card);
        }
        
        int winCount = 0;
        int totalCases = 0;
        
        // 상대방이 가져갈 모든 경우의 수 확인
        for (int i = 0; i < remainingDeck.size(); i++) {
            for (int j = i + 1; j < remainingDeck.size(); j++) {
                int oppA = remainingDeck.get(i);
                int oppB = remainingDeck.get(j);
                
                if (isStronger(A, B, oppA, oppB)) {
                    winCount++;
                }
                totalCases++;
            }
        }
        
        return (double) winCount / totalCases;
    }
    
    // 패의 우위를 결정하는 함수
    public static boolean isStronger(int A, int B, int oppA, int oppB) {
        int myRank = getRank(A, B);
        int oppRank = getRank(oppA, oppB);
        return myRank > oppRank;
    }
    
    // 패의 족보를 계산하는 함수 (큰 값일수록 강한 패)
    public static int getRank(int X, int Y) {
        if (X == Y) return X + 100; // 땡 패의 경우 100을 더해 우선순위 부여
        return (X + Y) % 10; // 끗 패의 경우 합의 일의 자리 반환
    }
}
