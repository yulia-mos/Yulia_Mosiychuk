import java.util.Arrays;
import java.util.Scanner;
public class Task2_extra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a number");
        long number = sc.nextLong();
        System.out.println(convert(number));
    }
    public static String convert(long number) {
        String[] address=convertToAddress(convertToBin(number));
        return String.join(".", address);
    }
    public static int[] convertToBin(long number) {
        int[] ip=new int[32];
        int i=0;
        while(number!=0.0) {
            ip[31-i] = (int)(number % 2);
            number = (int) (number / 2);
            i++;
        }
        return ip;
    }
    public static String[] convertToAddress(int[] ip) {
        String[] address=new String[4];
        for (int j=0; j<4; j++) {
            int oneOfIpNum = 0;
            for (int k = 0; k < 8; k++) {
                oneOfIpNum += (int) (Math.pow(2, 7 - k) * ip[j * 8 + k]);
            }
            address[j] = String.valueOf(oneOfIpNum);
        }
        return address;
    }
}
