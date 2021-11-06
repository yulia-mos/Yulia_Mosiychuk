import java.util.Arrays;
public class Task5 {
    public static void main(String[] args) {
        String strList ="Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        String[][] arrNew= createInvitationArray(strList);
        for (int i=0; i<arrNew.length; i++){
            System.out.println(Arrays.toString(arrNew[i]));
        }
    }
    public static String[][] createInvitationArray(String strList){
        String[] arr=strList.split(";");
        int length=arr.length;
        String[][] arrNew= new String[length][2];
        for (int i=0; i<length; i++){
            String[] arr_temp = arr[i].split(":");
            arrNew[i][1]=arr_temp[0].toUpperCase();
            arrNew[i][0]=arr_temp[1].toUpperCase();
        }
        return sortArray(arrNew);
    }
    public static String[][] sortArray(String[][] arr){
            int n = arr.length;
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j][0].compareTo(arr[j + 1][0])>0) {
                        String[] temp = arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                    if (arr[j][0].compareTo(arr[j + 1][0])==0){
                        if (arr[j][1].compareTo(arr[j + 1][1])>0){
                            String[] temp = arr[j];
                            arr[j]=arr[j+1];
                            arr[j+1]=temp;
                        }
                    }
                }
            }
            return arr;
    }
}
