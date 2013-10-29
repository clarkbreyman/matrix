package com.breyman.matrix;

/**
 * Basic matrix abstraction
 */
public interface Matrix extends CellFunction {
    int getRows();

    int getColumns();

    public default String getDimensions() {
        return String.format("(%d,%d)", getRows(), getColumns());
    }

    public default String print() {
        return print(6);
    }

    public default String print(int precision) {
        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < getRows(); r++) {
            builder.append("| ");
            for (int c = 0; c < getColumns(); c++) {
                String s = Double.toString(getCell(r, c));
                if (s.length() < precision) {
                    for (int i = 0; i < precision - s.length(); i++) {
                        builder.append(' ');
                    }
                }
                builder.append(s);
                builder.append("  ");
            }
            builder.append("|\n");
        }
        return builder.toString();
    }
}