
public class Task4 {
    public static void main(String[] args) {
        int[] numbers ={1, 3, 6, 2, 2, 0, 4, 5};
        int target = 5;
        System.out.println(countPairs(numbers, target));

    }
    public static int countPairs(int[] numbers, int target) {
        int count=0;
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j=i+1; j<length; j++){
                int sum=numbers[i]+numbers[j];
                if (sum==target){
                    count++;
                }
            }
        }
        return count;
    }

}
