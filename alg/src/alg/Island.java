package alg;

/**
 * [0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 */
public class Island {

    public int islandCount(int[][] grid) {
        int nRows = grid.length, nCols = 0;
        int count = 0;
        if (grid.length > 0) {
            nCols = grid[0].length;
            for (int row = 0; row < nRows; row++) {
                for (int col = 0; col < nCols; col++) {
                     if (grid[row][col] == 1) {
                         int left = getVal(row, col-1, grid, nRows, nCols);
                         int above = getVal(row-1, col, grid, nRows, nCols);
                         int right = getVal(row, col+1, grid, nRows, nCols);
                         int aboveRight = getVal(row -1, col+1, grid, nRows, nCols);
                         if (left == 0 && above == 0 ) {
                             if (right == 1) {
                                 if (aboveRight == 0) {
                                     count++;
                                 }
                             } else {
                                 count++;
                             }
                         }
                     }
                }
            }
        }
        return count;
    }

    private int getVal(int row, int col, int[][]grid, int maxRows, int maxCols) {
        if (row < 0 || col < 0 || row >= maxRows || col >= maxCols) {
            return 0;
        } else {
            return grid[row][col];
        }
    }


    public int islandPerimeter(int[][] grid) {
        int nRows = 0, nCols = 0;
        int perimeter = 0;
        if (grid != null) {
            nRows = grid.length;
            nCols = grid[0].length;
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    int left = j == 0 ? 0 : grid[i][j - 1];
                    int right = j == nCols - 1 ? 0 : grid[i][j + 1];
                    int top = i == 0 ? 0 : grid[i - 1][j];
                    int bottom = i == nRows - 1 ? 0 : grid[i + 1][j];
                    int current = grid[i][j];
                    System.out.print("[" + i +  "] [" + j + "] = " + current + " left=" + left +
                            " top=" + top + " right=" + right + " bottom=" + bottom);
                    if (current == 1) {
                        perimeter += (left ^ 1) + (top ^ 1) + (right ^ 1) + (bottom ^1);
                    }
                    System.out.println(" perimeter=" + perimeter);
                }
            }
        }
        return perimeter;
    }


    public static void main(String args[]) {
        int[][] gridGiven = {{0,1,0,0},
                {1,1,1,0},
                {0,1,1,0},
                {1,1,0,0}};
        int[][] grid = {{0},{0}, {1},{1}};
        int[][] empty = {{}};

        int[][] disjoint = {{0,1,0,0}, {1,0,0,0}, {0,-0,1,0}, {1,0,1,1}};
        int[][] gridInvertedL = {{0,1,0,0},
                {0,0,1,0},
                {0,1,1,0},
                {1,0,0,0}};

        Island island = new Island();

        System.out.println(island.islandCount(gridGiven));
        System.out.println(island.islandCount(grid));
        System.out.println(island.islandCount(empty));
        System.out.println(island.islandCount(disjoint));
        System.out.println(island.islandCount(gridInvertedL));

    }
}
