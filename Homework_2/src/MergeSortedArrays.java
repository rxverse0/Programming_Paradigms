public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 10};
        int[] arr2 = {2, 4, 6, 8, 9};

        int[] mergedArray = mergeArrays(arr1, arr2);

        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] merged = new int[len1 + len2];

        int i = 0, j = 0, k = 0;

        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < len1) {
            merged[k++] = arr1[i++];
        }

        while (j < len2) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }
}
