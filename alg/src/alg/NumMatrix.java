package alg;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper
 * left corner (row1, col1) and lower right corner (row2, col2).
 * <p>
 * (row2, col2).
 */
public class NumMatrix {

    int[][] matrix;
    int[][] fenwickTree;
    int nRows = 0;
    int nCols = 0;

    public NumMatrix(int[][] matrix) {
        if (matrix != null) {
            this.matrix = matrix;
            nRows = matrix.length;
            if (nRows > 0) {
                nCols = matrix[0].length;
            }
            this.fenwickTree = new int[nRows + 1][nCols + 1];
            this.matrix = new int[nRows][nCols];

            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }
    }

    public void update(int row, int col, int val) {
        if (nRows > 0 && nCols > 0) {
            // Fenwick tree stores only sums
            // So convert this absolute value to a delta from its original value
            int delta = val - matrix[row][col];
            matrix[row][col] = val;

            //Find the Fenwick node (1 based index) and all it's next nodes and add delta
            //In Fenwick tree, next index is defined as index + (index & (-index))
            for (int i = row + 1; i <= nRows; i += i & (-i)) {
                for (int j = col + 1; j <= nCols; j += j & (-j)) {
                    fenwickTree[i][j] += delta;
                }
            }
        }
    }

    private int sumStartToPosition(int row, int col) {
        int sum = 0;
        //Add up from node with index  = given row + 1 as Fenwick's content storage ignores node 0
        //Traverse up the tree till you hit the root node (0)
        if (nRows > 0 && nCols > 0) {
            for (int i = row + 1; i > 0; i -= i & -i) { //parent is (index - (index & (-index)))
                for (int j = col + 1; j > 0; j -= j & (-j)) {
                    sum += fenwickTree[i][j];
                }
            }
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        sum += sumStartToPosition(row2, col2); // This now has from start 0,0 to row2,col2
        if ((row1 != 0) && (col1 != 0))  {
            sum -= sumStartToPosition(row1 - 1, col2);
            sum -= sumStartToPosition(row2, col1 - 1);
            // We removed a little too much, lets back that range 0,0 to row1-1, col1-1
            sum += sumStartToPosition(row1 - 1, col1 - 1);
        } else if (row1 !=0 && col1 == 0) {
            sum -= sumStartToPosition(row1 - 1, col2);
        } else if (row1 == 0 && col1 != 0) {
            sum -= sumStartToPosition(row2, col1 - 1);
        }
        return sum;
    }


    public static void main(String args[]) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        int[][] n = null;
        int[][] empty = {{}};
        int[][] test = {{1,2}};

        NumMatrix nm = new NumMatrix(test);
        System.out.println(nm.sumRegion(0,0, 0,0) + " -> 1");
        System.out.println(nm.sumRegion(0,1, 0,1) + " -> 2");
        System.out.println(nm.sumRegion(0,1, 0,1) + " -> 2");
//        System.out.println(" parent of 7 " + findParent(7));
//        System.out.println(" next for 2 " + getNext(2));

        // Your NumMatrix object will be instantiated and called as such:
//        NumMatrix numMatrix = new NumMatrix(empty);
//        System.out.println(numMatrix.sumRegion(2, 1, 4, 3) + " -> 8");
//        numMatrix.update(3, 2, 2);
//        System.out.println(numMatrix.sumRegion(2, 1, 4, 3) + " -> 10");

    }





    public static int findParent(int index) {
        // x = get 2's compliment of the index   = -index
        // y = & x with original = (index & (-index))
        // parent = subtract the result (y) from the original number (index) = (index - (index & (-index))
        return (index - (index & (-index)));



    }

    public static int getNext(int index) {
        //x = get 2's compliment of the index = -index
        //y = & x with original = (index & (-index))
        //next = add y to original  = (index + (index & (-index)))
        return (index + (index & (-index)));
    }

    public int sumRegionNaive(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int row = row1; row <= row2 && row < matrix.length; row++) {

            for (int col = col1; col <= col2 && col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }

        }
        return sum;
    }


}