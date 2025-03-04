import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfs = new int[9];
        int sum = 0;

        // 입력 및 전체 합 계산
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }

        // 두 난쟁이 선택 및 합 검증
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - dwarfs[i] - dwarfs[j] == 100) {
                    // 일곱 난쟁이 출력
                    int[] result = new int[7];
                    int index = 0;
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            result[index++] = dwarfs[k];
                        }
                    }
                    Arrays.sort(result); // 오름차순 정렬
                    for (int dwarf : result) {
                        System.out.println(dwarf);
                    }
                    return; // 결과 출력 후 종료
                }
            }
        }
    }
}