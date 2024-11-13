import java.util.ArrayList;
import java.util.List;

public class sorting_choice {

    public static List<Integer> selectionSort(List<Integer> arr) {
        List<Integer> newArr = new ArrayList<>();
        while (!arr.isEmpty()) {
            int smallest = findSmallest(arr);
            newArr.add(arr.remove(smallest));
        }
        return newArr;
    }

    public static int findSmallest(List<Integer> arr) {
        int smallest = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(smallest)) {
                smallest = i;
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        List<Integer> x = new ArrayList<>();
        x.add(5);
        x.add(3);
        x.add(6);
        x.add(2);
        x.add(10);
        System.out.println(selectionSort(x));
    }
}
