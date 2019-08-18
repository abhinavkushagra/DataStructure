import java.util.Scanner;
import java.util.Arrays;
class MainTest{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[] count = new int[1001];
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = scan.nextInt();
            count[arr[i]]++;
        }
        int max = findMax(count);
        Arrays.sort(arr);
        while(arr[0] >= 0){
            int[] count1 = new int[1001];
            arr[0] += K;
            for(int i = 1; i < N; i++)
                arr[i] -= K;
            for(int i = 0; i < N; i++){
                //System.out.print(arr[i] + " ");
                if(arr[i] >= 0)
                    count1[arr[i]]++;
            }
            int temp = findMax(count1);
            if(temp > max)
                max = temp;
            Arrays.sort(arr);
        }
        System.out.println(max);
    }
    static int findMax(int[] count){
        int max = -199;
        for(int i = 1; i < 1001; i++){
            if(count[i] > max)
                max = count[i];
        }
        return max;
    }
}