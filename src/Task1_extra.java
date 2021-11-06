import java.util.Scanner;

public class Task1_extra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a number");
        int number = sc.nextInt();
        System.out.println(rearrange(number));

    }
    public static int rearrange(int number) {
        int i=1;
        while((int)(number/decPow(i))!=0){
            int rightDigit = number % decPow(i)/decPow(i-1);
            int leftDigit=number%decPow(i+1)/decPow(i);
            if (rightDigit>leftDigit){
                number=number-rightDigit*decPow(i-1)-leftDigit*decPow(i);
                number=number+leftDigit*decPow(i-1)+rightDigit*decPow(i);
                return number;
            }
            i++;
        }
        return -1;
    }
    public static int decPow( int pow) {
            return (int)Math.pow(10, pow);
    }
}
