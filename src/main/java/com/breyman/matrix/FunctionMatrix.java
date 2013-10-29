package com.breyman.matrix;

/**
 *
 */
public class FunctionMatrix extends AbstractMatrix {
    private final CellFunction function;

    public FunctionMatrix(int rows, int columns, CellFunction function) {
        super(rows, columns);
        this.function = function;
    }

    @Override
    public double getCell(int row, int column) {
        return function.getCell(row, column);
    }
}
