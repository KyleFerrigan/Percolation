public class Percolation {

    private boolean[][] grid;//Array that holds grid of open or closed sites
    private int loopMax;
    private WeightedQuickUnionUF wqFind;

    public Percolation(int N) { //create N-by-N grid, with all sites blocked
        try {
            grid = new boolean[N][N];
        }
        catch (IllegalArgumentException e) {
            System.out.println("N cannot be less than or equal to 0");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = false; //False means blocked, all sites blocked with this command
            }
        }

        loopMax = N-1; //Max size of array (minus one because arrays start at 0)
        wqFind = new WeightedQuickUnionUF(((loopMax +2) * (loopMax +1)) + (loopMax +1)); //Creates a QuickFindUF instance with max size of N
    }

    public void open(int i, int j){ //open site (row i, column j) if it is not open already
        try {
            grid[i][j] = true; //Opens site
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Outside prescribed range");
        }
    }

    public boolean isOpen(int i, int j){ //is site (row i, column j) open?
        try {
            return grid[i][j]; //returns bool if its open
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Outside prescribed range");
            return false;
        }
    }

    public boolean isFull(int i, int j) { //is site (row i, column j) full?
        try {
            if(!isOpen(i,j)){//if site isn't open it cannot be full
                return false;
            }

            for(int k = 0; k< loopMax; k++){
                if (wqFind.connected(arrayID(i,j), arrayID(0,k))){
                    return true;
                }
            }
            return false;
        }

        catch (IndexOutOfBoundsException e) {
            System.out.println("Outside prescribed range");
            return false;
        }
    }

    public boolean percolates(){ //does the system percolate?
        //Check bottom sites for a site that is open, if so call isFull
        for (int i = 0; i<= loopMax; i++) {
            if (isOpen(loopMax,i)){ //if bottom site is open
                if(isFull(loopMax,i)){ //if bottom site is full, this is more expensive so checking if its open first makes more sense
                    return true; //if bottom site is full it means it will percolate, no more sites need to be tested.
                }
            }
        }
        return false; //if no full sites found this will execute
    }

    public void populateQuickFind(){ //connects together sites that are both open if they are next to each other
        for(int i = 0; i< loopMax; i++){ //Horizontal Linking
            for(int j = 0; j< loopMax; j++){
                if(isOpen(i,j) && isOpen(i+1,j)){ //if two open sites are next to each other horizontally
                    wqFind.union(arrayID(i,j), arrayID(i+1,j));
                }
                if(isOpen(i,j) && isOpen(i,j+1)){ //if two open sites are next to each other vertically
                    wqFind.union(arrayID(i,j), arrayID(i,j+1));
                }
            }
        }
    }

    public int arrayID(int x, int y) { //Convert the 2d array indices to 1d array index
        int arrID = (((loopMax +1) * (x)) + (y));
        return arrID;
    }
}

