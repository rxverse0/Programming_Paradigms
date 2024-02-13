package lab4;

public class GenericSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}

//        do {
//            swapped = false;
//            for (int i = 1; i < n; i++) {
//                if (arr[i - 1].compareTo(arr[i]) > 0) {
//                    // Swap arr[i-1] and arr[i]
//                    T temp = arr[i - 1];
//                    arr[i - 1] = arr[i];
//                    arr[i] = temp;
//                    swapped = true;
//                }
//            }
//        } while (swapped);



