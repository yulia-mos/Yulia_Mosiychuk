import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a number");
        int number = sc.nextInt();
        System.out.println(digitalRoot(number));
    }
    public static int digitalRoot(int number) {
        int sum =0;
        do {
            sum = 0;
            while (number != 0) {
                sum += number % 10;
                number = (int) number / 10;
            }
            int temp=number;
            number=sum;
            sum=temp;
        } while (((int)number/10!=0));
        return number;
    }
}
