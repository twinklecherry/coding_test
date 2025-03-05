import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ele = Integer.parseInt(br.readLine());

        while (ele-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int[] numbers = new int[45];
            for (int i = 1; i < 45; i++) {
                numbers[i] = i * (i + 1) / 2;
            }

            boolean found = false; // 조건을 만족하는 조합을 찾았는지 여부
            for (int i = 1; i < 45; i++) {
                for (int j = 1; j < 45; j++) {
                    for (int l = 1; l < 45; l++) {
                        if (numbers[i] + numbers[j] + numbers[l] == k) {
                            System.out.println(1);
                            found = true;
                            break; // 조건을 만족하는 조합을 찾았으므로 루프 종료
                        }
                    }
                    if (found) break; // 조건을 만족하는 조합을 찾았으므로 루프 종료
                }
                if (found) break; // 조건을 만족하는 조합을 찾았으므로 루프 종료
            }
            if (!found) { // 조건을 만족하는 조합을 찾지 못한 경우
                System.out.println(0);
            }
        }
    }
}