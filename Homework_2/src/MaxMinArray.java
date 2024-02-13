public class MaxMinArray {
    public static void main(String[] args) {

        //--------------> 1. Find the maximum and minimum in an array of integers.
        int[] array = {5, 3, 9, 1, 8, 2, 4};

        if (array.length > 0) {int min = array[0];
            int max = array[0];

            for (int i = 1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
                if (array[i] > max) {
                    max = array[i];
                }
            }

            System.out.println("Minimum: " + min);
            System.out.println("Maximum: " + max);
        } else {
            System.out.println("The array is empty.");
        }

        //------------------>2. Find the sum of even elements in an array of integers.
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) {
                sum += array[i];
            }
        }

//        for (int num : array) {
//            if (num % 2 == 0) {
//                sum += num;
//            }
//        }

        System.out.println("Sum of even elements: " + sum);
    }
}
