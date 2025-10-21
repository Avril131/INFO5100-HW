public class MidExam {

    // Develop a program that calculates the sum of all elements of a matrix. 
    // Use loops.
    public static int sumOfMatrix(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    // print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // java format output in two digits
                System.out.printf("%2d ", matrix[i][j]);
                
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    
        //Initiate any matrix of any size no less than 2 x 3 in your program. 
        int[][] matrix = {{1,2,3, 4}, {5,6,7, 8}, {9,10,11,12}};
        //Show the matrix as an output of the program.
        printMatrix(matrix);
        System.out.println("Sum of matrix: " + sumOfMatrix(matrix));
    }
}
