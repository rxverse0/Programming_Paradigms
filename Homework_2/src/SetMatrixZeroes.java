public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 2, 9, 4},
                {4, 0, 6, 8},
                {7, 8, 9, 7},
                {7, 9, 3, 6}
        };

        setZeroes(matrix);

        // Print the modified matrix
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[] zeroRows = new boolean[numRows];
        boolean[] zeroCols = new boolean[numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Set rows to 0
        for (int i = 0; i < numRows; i++) {
            if (zeroRows[i]) {
                for (int j = 0; j < numCols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set columns to 0
        for (int j = 0; j < numCols; j++) {
            if (zeroCols[j]) {
                for (int i = 0; i < numRows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
