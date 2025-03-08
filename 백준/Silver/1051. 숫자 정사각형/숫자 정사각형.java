import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] rectangle = new char[N][M];

        for(int i=0; i<N; i++){ //입력받음.
            rectangle[i] = sc.next().toCharArray();
            // 42101
            // 22100
            // 22101
        }
        
        int maxSize = 1;    //최소크기 지정(1x1부터 시작하는 정사각형의 크기)
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int k=1; i+k<N && j+k<M; k++){
                    if( rectangle[i][j] == rectangle[i][j+k]
                      &&rectangle[i][j] == rectangle[i+k][j]
                      &&rectangle[i][j] == rectangle[i+k][j+k] ){
                        maxSize = Math.max(maxSize, (k+1)*(k+1));
                      }
                }
            }
        }
        System.out.println(maxSize);
    }
}