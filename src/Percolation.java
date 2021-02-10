public class Percolation {

    boolean[][] grid;//Grid array that holds grid

    public Percolation(int N){ //create N-by-N grid, with all sites blocked
        grid = new boolean[N][N];
        for (int i = 0; i<N; i++){
            for (int j=0; i<N; i++){
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

        return false;//placeholder
    }

    public boolean percolates(){ //does the system percolate?

        return false; //placeholder
    }

    public static void main(String args[]){
        System.out.println("hello world");
    }
}

