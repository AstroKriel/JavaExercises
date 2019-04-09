package coll.Matrix;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix<String> m = new Matrix<String>(2, 2);

        m.insert(0, 0, "a");
        m.insert(0, 1, "b");
        m.insert(1, 0, "c");
        m.insert(1, 1, "d");

        System.out.println(m.toString() + "\n");

        System.out.println(m.get(1, 1));
    }
}
