import java.util.*;

class Main {
    static class State {
        int index, volume;

        State(int index, int volume) {
            this.index = index;
            this.volume = volume;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 곡 개수
        int S = sc.nextInt(); // 시작 볼륨
        int M = sc.nextInt(); // 볼륨 최대값
        
        int[] V = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            V[i] = sc.nextInt();
        }

        Queue<State> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][M + 1];

        queue.add(new State(0, S));
        visited[0][S] = true;

        int maxVolume = -1;

        while (!queue.isEmpty()) {
            State state = queue.poll();
            int idx = state.index;
            int vol = state.volume;

            if (idx == N) {
                maxVolume = Math.max(maxVolume, vol);
                continue;
            }

            int nextIdx = idx + 1;
            if (vol + V[nextIdx] <= M && !visited[nextIdx][vol + V[nextIdx]]) {
                queue.add(new State(nextIdx, vol + V[nextIdx]));
                visited[nextIdx][vol + V[nextIdx]] = true;
            }
            if (vol - V[nextIdx] >= 0 && !visited[nextIdx][vol - V[nextIdx]]) {
                queue.add(new State(nextIdx, vol - V[nextIdx]));
                visited[nextIdx][vol - V[nextIdx]] = true;
            }
        }

        System.out.println(maxVolume);
    }
}