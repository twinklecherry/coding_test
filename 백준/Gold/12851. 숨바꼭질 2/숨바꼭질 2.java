import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] time = new int[100001];    //최소 시간
    static int[] count = new int[100001];   //방법의 수 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //수빈위치
        K = Integer.parseInt(st.nextToken()); //동생위치

        bfs(N);

        System.out.println(time[K]);    //가장빠른시간
        System.out.println(count[K]);   //가장 빠른시간으로 도달한 방법의 수
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        time[start] = 0;    //시작시점 0초
        count[start] = 1;   //시작지점 도달방법 1가지

        while(!queue.isEmpty()){
            int now = queue.poll();
            
            //3가지이동
            for(int next : new int[]{now-1, now+1, now*2}){
                if(next<0 || next>100000) continue;

                //첫방문
                if(time[next]==0 && next!=N){
                    time[next] = time[now] +1;  //시간기록 1초
                    count[next] = count[now];   //방법개수 저장
                    queue.offer(next);
                } 
                //방문했지만 현재경로도 최소 시간으로 도달가능하면
                else if(time[next] == time[now]+1){
                    count[next] += count[now]; ///경로추가
                }

            }
        }
    }
}