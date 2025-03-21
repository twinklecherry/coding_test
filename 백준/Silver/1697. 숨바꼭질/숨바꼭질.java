import java.io.*;
import java.util.*;

class Main {
    static int MAX = 100000; 
    static boolean[] visited = new boolean[MAX + 1]; 
    static int[] dist = new int[MAX + 1]; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        System.out.println(bfs(N, K)); 
    }

    public static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current == target) return dist[current];

            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX && !visited[next]) {
                    visited[next] = true; 
                    dist[next] = dist[current] + 1; 
                    queue.add(next);
                }
            }
        }
        return -1; 
    }
}