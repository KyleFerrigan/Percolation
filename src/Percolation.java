public class Percolation {

    boolean[][] grid;//Array that holds grid of open or closed sites

    public Percolation(int N){ //create N-by-N grid, with all sites blocked
        grid = new boolean[N][N];
        for (int i = 0; i<N; i++){
            for (int j=0; j<N; j++){
                grid[i][j] = false; //False means blocked, all sites blocked with this command
            }
        }
    }

    public void open(int i, int j){ //open site (row i, column j) if it is not open already
        grid[i][j] = true; //Opens site
    }

    public boolean isOpen(int i, int j){ //is site (row i, column j) open?
        return grid[i][j]; //returns bool if its open
    }

    public boolean isFull(int i, int j){ //is site (row i, column j) full?
        //TODO check sites around the given site and find a route to the top, if unable to do so return false
        return false;//placeholder
    }

    public boolean percolates(){ //does the system percolate?
        //TODO check bottom sites for a site that is open, if so call isFull
        return false; //placeholder
    }

    public static void main(String args[]){
        System.out.println("hello world");
    }
}

