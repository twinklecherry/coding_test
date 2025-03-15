import java.util.*;

class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4]; // +, -, *, /
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt(); // 연산자 개수 입력
        }

        // 백트래킹 수행
        dfs(1, numbers[0]);

        // 최댓값과 최솟값 출력
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    static void dfs(int index, int result) {
        if (index == N) { // 모든 숫자를 사용했을 때
            maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) { // 해당 연산자가 남아있는 경우
                operators[i]--; // 연산자 사용

                int newResult = calculate(result, numbers[index], i);
                dfs(index + 1, newResult); // 다음 숫자로 이동

                operators[i]++; // 연산자 복구 (백트래킹)
            }
        }
    }

    static int calculate(int a, int b, int op) {
        switch (op) {
            case 0: return a + b; // 덧셈
            case 1: return a - b; // 뺄셈
            case 2: return a * b; // 곱셈
            case 3: return a / b; // 나눗셈 (정수 나눗셈)
        }
        return 0;
    }
}