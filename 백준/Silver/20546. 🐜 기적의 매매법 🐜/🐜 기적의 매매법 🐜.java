import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine());  // 초기 자금
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] stockPrices = new int[14];
        for (int i = 0; i < 14; i++) {
            stockPrices[i] = Integer.parseInt(st.nextToken());
        }
        
        // BNP 전략 (준현이)
        int bnpCash = cash;
        int bnpStocks = 0;
        
        for (int i = 0; i < 14; i++) {
            if (bnpCash >= stockPrices[i]) {  
                int buy = bnpCash / stockPrices[i];  // 최대한 매수할 수 있는 주식 수
                bnpStocks += buy;
                bnpCash -= buy * stockPrices[i];
            }
        }

        // TIMING 전략 (성민이)
        int timingCash = cash;
        int timingStocks = 0;
        
        for (int i = 3; i < 14; i++) {
            // 3일 연속 하락 시 전량 매수
            if (stockPrices[i - 3] > stockPrices[i - 2] &&
                stockPrices[i - 2] > stockPrices[i - 1] &&
                stockPrices[i - 1] > stockPrices[i]) {
                if (timingCash >= stockPrices[i]) {
                    int buy = timingCash / stockPrices[i];
                    timingStocks += buy;
                    timingCash -= buy * stockPrices[i];
                }
            }

            // 3일 연속 상승 시 전량 매도
            if (stockPrices[i - 3] < stockPrices[i - 2] &&
                stockPrices[i - 2] < stockPrices[i - 1] &&
                stockPrices[i - 1] < stockPrices[i]) {
                if (timingStocks > 0) {  
                    timingCash += timingStocks * stockPrices[i];  // 전량 매도
                    timingStocks = 0;
                }
            }
        }

        // 1월 14일 최종 자산 계산
        int bnpTotal = bnpCash + (bnpStocks * stockPrices[13]);
        int timingTotal = timingCash + (timingStocks * stockPrices[13]);

        // 결과 출력
        if (bnpTotal > timingTotal) {
            System.out.println("BNP");
        } else if (bnpTotal < timingTotal) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
