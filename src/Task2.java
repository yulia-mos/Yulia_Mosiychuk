
import java.util.Scanner;
public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a string");
        String str = sc.nextLine();
        String symbolNonRepeat = firstNonRepeatingLetter(str);
        System.out.println(symbolNonRepeat);


    }
    public static String firstNonRepeatingLetter(String str) {
        int length=str.length();
        String lowerStr=str.toLowerCase();
        for (int i=0; i<length; i++){;
            char symbol = lowerStr.charAt(i);
            if (lowerStr.indexOf(symbol)==lowerStr.lastIndexOf(symbol)){
                return String.valueOf(str.charAt(i));
            }
        }
        return "";
    }
}
