public class MaxMinArray {
    public static void main(String[] args) {
        int[] array = {5, 3, 9, 1, 8, 2, 4}; // Replace this with your array of integers

        if (array.length > 0) {
            int min = array[0]; // Assume the first element is the minimum
            int max = array[0]; // Assume the first element is the maximum

            for (int i = 1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i]; // Update minimum if a smaller value is found
                }
                if (array[i] > max) {
                    max = array[i]; // Update maximum if a larger value is found
                }
            }

            System.out.println("Minimum: " + min);
            System.out.println("Maximum: " + max);
        } else {
            System.out.println("The array is empty.");
        }
    }
}
