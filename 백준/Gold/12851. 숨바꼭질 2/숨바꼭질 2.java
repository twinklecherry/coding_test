import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] time = new int[100001]; 
    static int[] ways = new int[100001]; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  
        K = Integer.parseInt(st.nextToken()); 
        if (N == K) { 
            System.out.println(0);
            System.out.println(1);
            return;
        }

        System.out.println(bfs());
    }

    static String bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 0;
        ways[N] = 1; 

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next < 0 || next > 100000) continue; 

                if (time[next] == 0 && next != N) {  
                    time[next] = time[current] + 1;
                    ways[next] = ways[current];  
                    queue.add(next);
                } else if (time[next] == time[current] + 1) {  
                    ways[next] += ways[current]; 
                }
            }
        }

        return time[K] + "\n" + ways[K];  
    }
}