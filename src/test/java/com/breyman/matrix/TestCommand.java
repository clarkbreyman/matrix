package com.breyman.matrix;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

/**
 *
 */
public class TestCommand {
    public static final void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out))) {
            writer.println("Running...");
            Matrix a = new MatrixBuilder(3, 4, (r, c) -> 10 * r + c).build();
            Matrix b = new MatrixBuilder(4, 3, (r, c) -> c * 5).build();
            Matrix c = new MatrixBuilder(a).times(b).build();
            writer.print(a.print() + "times \n" + b.print() + "equals\n" + c.print());
            writer.println("Finished.");
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
