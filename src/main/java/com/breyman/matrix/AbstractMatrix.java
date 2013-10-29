package com.breyman.matrix;

/**
 * Matrix base class defining dimensions of the matrix but not the values
 */
public abstract class AbstractMatrix implements Matrix {
    private final int rows;
    private final int columns;

    protected AbstractMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public abstract double getCell(int row, int column);
}