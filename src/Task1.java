import java.util.ArrayList;
import java.lang.String;
import java.util.Arrays;
public class Task1 {

    public static void main(String[] args) {
        ArrayList list = createList();
        list=getIntegersFromList(list);
        System.out.println(sortList((ArrayList<Integer>)list));

    }
    public static ArrayList<?> createList() {
        ArrayList list = new ArrayList(Arrays.asList(5,2,"a","b","aasf","1","123",231));
        return list;
    }
    public static ArrayList<?> getIntegersFromList(ArrayList<?> list) {
        int n=list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i) instanceof String){
                list.remove(i);
                n--;
                i--;
            }
        }
        return list;
    }
    public static ArrayList<?> sortList(ArrayList<Integer> list){
        int n = list.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }
}
