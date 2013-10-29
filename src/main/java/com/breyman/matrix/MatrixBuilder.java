package com.breyman.matrix;

/**
 * User: Clark Breyman
 */
public class MatrixBuilder {
    private Matrix matrix;

    public MatrixBuilder(Matrix matrix) {
        this.matrix = matrix;
    }

    public MatrixBuilder(final int rows, final int columns, final CellFunction fn) {
        matrix = new FunctionMatrix(rows, columns, fn);
    }

    public MatrixBuilder(final int rows, final int columns, final double d) {
        this(rows, columns, (r, c) -> d);
    }

    public Matrix build() {
        return matrix;
    }

    // Scalar math
    public MatrixBuilder plus(double d) {
        matrix = new FunctionMatrix(matrix.getRows(), matrix.getColumns(), (r, c) -> matrix.getCell(r, c) + d);
        return this;
    }

    public MatrixBuilder minus(double d) {
        return plus(-d);
    }

    public MatrixBuilder times(double d) {
        matrix = new FunctionMatrix(matrix.getRows(), matrix.getColumns(), (r, c) -> matrix.getCell(r, c) * d);
        return this;
    }

    public MatrixBuilder div(double d) {
        matrix = new FunctionMatrix(matrix.getRows(), matrix.getColumns(), (r, c) -> matrix.getCell(r, c) / d);
        return this;
    }

    // Matrix math
    public MatrixBuilder plus(Matrix m) {
        matrix = new FunctionMatrix(matrix.getRows(), matrix.getColumns(), (r, c) -> matrix.getCell(r, c) + m.getCell(r, c));
        return this;
    }

    public MatrixBuilder minus(Matrix m) {
        matrix = new FunctionMatrix(matrix.getRows(), matrix.getColumns(), (r, c) -> matrix.getCell(r, c) - m.getCell(r, c));
        return this;
    }

    public MatrixBuilder times(Matrix m) {
        if (matrix.getColumns() != m.getRows()) {
            throw new IllegalArgumentException(
                    String.format("Cannot multiply a %s matrix by a %s matrix",
                            matrix.getDimensions(), m.getDimensions()));
        }
        final Matrix oldMatrix = matrix;
        CellFunction fn = (r, c) -> {
            double sum = 0;
            for (int i = 0; i < oldMatrix.getColumns(); i++) {
                sum += oldMatrix.getCell(r, i) * m.getCell(i, c);
            }
            return sum;
        };
        matrix = new FunctionMatrix(matrix.getRows(), m.getColumns(), fn);
        return this;
    }
}