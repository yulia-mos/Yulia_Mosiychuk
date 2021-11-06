import java.util.Arrays;
import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        //1 3 6 2 2 0 4 5
        int[] numbers =createArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a target");
        int target= sc.nextInt();
        Arrays.sort(numbers);
        System.out.println(countPairs(numbers, target));

    }
    public static int countPairs(int[] numbers, int target) {
        int count=0;
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j=i+1; j<length; j++){
                int sum=numbers[i]+numbers[j];
                if (sum>target){
                    break;
                }
                else if (sum==target){
                    count++;
                }

            }
        }
        return count;

    }
    public static int[] createArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a length of an array");
        int length= sc.nextInt();
        System.out.println("Input an array of numbers");
        int[] numbers=new int[length];
        for (int i=0; i<length; i++) {
            numbers[i] = sc.nextInt();
        }
        return numbers;
    }
}
