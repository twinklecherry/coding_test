import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        long a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b; // Fn = Fn-1 + Fn-2
            a = b; // 이전 값을 갱신
            b = temp;
        }

        System.out.println(b);
    }
}