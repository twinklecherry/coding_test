import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int height = 100;
        int totSum = 0;
        
        for(int i=0; i<9; i++){
            int a = Integer.parseInt(br.readLine());
            list.add(a);
            totSum += a;
        }
        
        Collections.sort(list);

        int height2 = totSum-height;
        int start = 0;
        int end = list.size()-1;

        while(start!=end){
            int sum = 0;
            sum += list.get(start);
            sum += list.get(end);

            if(sum < height2){
                start++;
            }
            if(sum > height2){
                end--;
            }
            if(sum == height2){
                list.remove(end);
                list.remove(start);
                break;
            }
        }

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}