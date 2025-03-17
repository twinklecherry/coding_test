import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        //첫번째줄입력받고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();

        visited = new boolean[N+1];
        bfs(V);
    }
    //DFS(재귀)
    static void dfs(int node){
        visited[node] = true;
        System.out.print(node +" ");

        for(int next : graph[node]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
    //BFS(큐)
    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int node = que.poll();
            System.out.print(node + " ");
            
            for(int next : graph[node]){
                if(!visited[next]){
                    que.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}