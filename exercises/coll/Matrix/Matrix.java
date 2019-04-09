package coll.Matrix;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A generic 2D-matrix.
 * @param <E> the cell type.
 */
public class Matrix <E> implements Iterable {
    private int numRows;
    private int numCols;
    private ArrayList vals[];

    /**
     * Constructs a Matrix.
     *
     * @param rows - the number of rows.
     * @param columns - the number of columns.
     */
    public Matrix(int rows, int columns) {
        if (0 < rows && 0 < columns) {
            this.numRows = rows;
            this.numCols = columns;
            vals = new ArrayList [this.numCols];
            for (int col = 0; col < this.numCols; col++) {
                vals[col] = new ArrayList<E>();
                for (int row = 0; row < this.numRows; row ++) {
                    vals[col].add(null);
                }
            }
        }
    }

    /**
     * Assigns a value to a given cell, specified by its row, column coordinates.
     *
     * @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @param value - the value to be assigned to the given cell.
     */
    public void insert(int row, int column, E value) {
        if (row < this.numRows && column < this.numCols) {
            vals[column].set(row, value);
        }
    }

    /**
     * Gets the value at a given cell, specified by its row, column coordinates.
     *
     * @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @return the value located at the given cell.
     */
    public E get(int row, int column) {
        if (0 < this.numRows*this.numCols) {
            return (E) vals[column].get(row);
        }
        return null;
    }

    /**
     * Gets the total number of cells in the matrix.
     *
     * @return an int equal to the total number of cells in the matrix.
     */
    public int size() {
        return this.numCols * this.numRows;
    }

    /**
     * Converts the matrix to String format.
     *
     * @return a String representation of the matrix.
     */
    public String toString() {
        String str = "";
        for (int row = 0; row < this.numRows; row++) {
            for (int col = 0; col < this.numCols; col++) {
                str += vals[col].get(row).toString();
                if (col < this.numCols - 1) {
                    str += "\t";
                }
            }
            if (row < this.numRows - 1) {
                str += "\n";
            }
        }
        return str;
    }

    /**
     * Gets an iterator for the matrix. The iterator follows column-major order.
     *
     * @return an iterator for the matrix.
     */
    public Iterator<E> iterator() {
        ArrayList<E> elememts = new ArrayList<E>();
        for (int col = 0; col < this.numCols; col++) {
            for (int row = 0; row < this.numRows; row++) {
                elememts.add((E) vals[col].get(row));
            }
        }
        return elememts.iterator();
    }
}