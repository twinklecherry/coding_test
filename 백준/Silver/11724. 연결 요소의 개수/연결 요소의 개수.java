import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;

        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int i=1; i<=N; i++){
            Collections.sort(list[i]);
        }

        for(int i=1; i<=N; i++){
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        
        System.out.print(count);
    }

    static void dfs(int node){
        visited[node] = true;
        
        for(int next: list[node]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}