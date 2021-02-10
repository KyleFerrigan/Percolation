public class Percolation {

    boolean[][] grid;//Array that holds grid of open or closed sites

    public Percolation(int N) { //create N-by-N grid, with all sites blocked
        try {
            grid = new boolean[N][N];
        } catch (IllegalArgumentException e) {
            System.out.println("N cannot be less than or equal to 0");
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = false; //False means blocked, all sites blocked with this command
            }
        }
    }

    public void open(int i, int j){ //open site (row i, column j) if it is not open already
        try {
            grid[i][j] = true; //Opens site
        }
        catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println("Outside prescribed range");
        }
    }

    public boolean isOpen(int i, int j){ //is site (row i, column j) open?
        try {
            return grid[i][j]; //returns bool if its open
        }
        catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println("Outside prescribed range");
            return false;
        }
    }

    public boolean isFull(int i, int j) { //is site (row i, column j) full?
        try {
            //TODO check sites around the given site and find a route to the top, if unable to do so return false
            int size = grid.length;
            //check what edge we are on
            if (j == size - 1) {//check if on the bottom row
                if (i == size - 1) {//bottom right

                }
                else if (i == 0) {//bottom left

                }
                else {// bottom somewhere in the middle aisles

                }
            }

            else if (j == 0) { //top row
                return isOpen(i, j);//if in top row always full if its open
            }

            else {//in the middle rows
                if (i == 0) {//site is on left aisle

                }
                else if (i == size - 1) {//site is on right aisle

                }
                else {//site is not on an edge

                }
            }

        }

        catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println("Outside prescribed range");
            return false;
        }
    }

    public boolean percolates(){ //does the system percolate?
        //Check bottom sites for a site that is open, if so call isFull
        int size = grid.length;
        for (int i = 0; i<size; i++) {
            if (isOpen(size-1,i)){ //if bottom site is open
                if(isFull(size-1,i)){ //if bottom site is full, this is more expensive so checking if its open first makes more sense
                    return true; //if bottom site is full it means it will percolate, no more sites need to be tested.
                }
            }
        }
        return false; //if no full sites found this will execute
    }

    public static void main(String args[]){
        System.out.println("Percolation Started");
        Percolation p = new Percolation(20);
        System.out.println("Percolates? " + p.percolates());

    }
}

