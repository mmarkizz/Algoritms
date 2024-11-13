public class quick_sorting {
    public static void main(String[] args) {
        int[] array = { 10, 5, 2, 3 };
        int[] sortedArray = quicksort(array);
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] quicksort(int[] array) {
        if (array.length < 2) {
            return array;
        } else {
            int pivot = array[0];
            int[] less = new int[array.length - 1];
            int[] greater = new int[array.length - 1];
            int lessIndex = 0;
            int greaterIndex = 0;

            for (int i = 1; i < array.length; i++) {
                if (array[i] < pivot) {
                    less[lessIndex++] = array[i];
                } else {
                    greater[greaterIndex++] = array[i];
                }
            }

            int[] sortedLess = quicksort(new int[lessIndex]);
            int[] sortedGreater = quicksort(new int[greaterIndex]);

            int[] sortedArray = new int[array.length];
            int index = 0;
            for (int num : sortedLess) {
                sortedArray[index++] = num;
            }
            sortedArray[index++] = pivot;
            for (int num : sortedGreater) {
                sortedArray[index++] = num;
            }
            return sortedArray;
        }
    }
}