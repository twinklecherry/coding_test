import java.io.*;
import java.util.*;

class Main {
    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1,0);
        
    }

    static void dfs(int start, int depth){
        if(depth==M){
            for(int i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(start>i){
                continue;
            }

            arr[depth] = i;
            dfs(i, depth+1);
        }
    }
}