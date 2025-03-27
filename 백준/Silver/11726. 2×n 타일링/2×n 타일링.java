import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int a = 1, b = 2, temp;

        for (int i = 3; i <= n; i++) {
            temp = (a + b) % 10007;
            a = b;
            b = temp;
        }

        System.out.println(b);
    }
}