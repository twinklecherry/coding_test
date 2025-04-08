import java.util.*;
import java.io.*;

class Main{
	static int N;
	static int minV = Integer.MAX_VALUE;
	static int maxV = Integer.MIN_VALUE;
	static int[] nums;
	static int[] cal; // +, -, *, /
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //수의 개수
		StringTokenizer st;
		
		nums = new int[N];
		cal = new int[4];
		
		//nums 데이터 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		//cal 데이터 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		
		calculate(1, nums[0]);// 첫 번째 수부터 시작
		
		System.out.println(maxV);
		System.out.println(minV);
		
	}
	
	static void calculate(int idx, int result) {
		if(idx==N) {
			maxV = Math.max(maxV, result);
			minV = Math.min(minV, result);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(cal[i]>0) {
				cal[i]--;
				if(i==0) 	  calculate(idx+1, result+nums[idx]);
				else if(i==1) calculate(idx+1, result-nums[idx]);
				else if(i==2) calculate(idx+1, result*nums[idx]);
				else if(i==3) calculate(idx+1, result/nums[idx]);
				cal[i]++;
			}
		}
	}
}
