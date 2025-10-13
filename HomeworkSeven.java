public class HomeworkSeven {
    public static void main(String[] args) {
        int[][] A = {{2, 3, 4}, {3, 4, 5}};
        
        int[][] B = {{1, 2}, {3, 4}, {5, 6}};
        
        // Check the dimension of the matrix
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;
        
    
        // Check if the matrix can be multiplied
        if (colsA != rowsB) {
            System.out.println("Cannot multiply matrix A*B");
            return;
        }
        
        System.out.println("Matrix can be multiplied!");
        
        int[][] result = new int[rowsA][colsB];
        
        // Use nested loop to calculate
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }

        // Output the result
        System.out.println("\nThe result of matrix A*B:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}