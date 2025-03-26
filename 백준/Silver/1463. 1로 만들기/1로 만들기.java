import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int num, count;
        Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));

        boolean[] visited = new boolean[N+1];

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int num = cur.num, count = cur.count;

            if(num == 1){
                System.out.println(count);
                return;
            }

            if(num%3==0 && !visited[num/3]){
                queue.add(new Node(num/3, count+1));
                visited[num/3]=true;
            }
            if(num%2==0 && !visited[num/2]){
                queue.add(new Node(num/2, count+1));
                visited[num/2] = true;
            }
            if(!visited[num-1]){
                queue.add(new Node(num-1, count+1));
                visited[num-1] = true;
            }
        }
    }
}