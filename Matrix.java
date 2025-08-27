package MatrixMultiplication;

public class Matrix {
    int rows;
    int columns;
    int[][] matrix;

    // Instantiates with known rows and columns, checks if all rows e
    public Matrix(int[][] mat, int n, int m) {
        for (int i = 0; i < mat.length; ++i) {
            if (mat[i].length != mat[0].length) {
                throw new IllegalArgumentException("Matrix is missing values. Rows are not of equal length");
            }
        }
        matrix = mat;
        rows = n;
        columns = m;
    }

    // Instantiates matrix without a known row and column length
    public Matrix(int[][] mat) {
        this(mat, mat.length, mat[0].length);
    }

    public int[][] multiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumns() != matrix2.getRows()) {
            throw new IllegalArgumentException("The columns of matrix 1 do not match the rows of matrix 2. Must be m x n by n x *.");
        }

        int[][] newMatrix = new int[matrix1.getRows()][matrix2.getColumns()];

        for (int i = 0; i < matrix1.getRows(); ++i) {
            for (int j = 0; j < matrix2.getColumns(); ++j) {
                for (int k = 0; k < matrix1.getColumns(); ++k) {
                    newMatrix[i][j] += matrix1.getMatrix()[i][k] *
                                                      matrix2.getMatrix()[k][j];
                }
            }
        }
        return newMatrix;
    }

    public void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; ++i) {
            System.out.print("| ");
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.print(" |");
            System.out.println();
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
