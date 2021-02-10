public class Percolation {

    private boolean[][] grid;//Array that holds grid of open or closed sites
    private int max;
    private QuickFindUF qFind;

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

        max = N-1; //Max size of array (minus one because arrays start at 0
        qFind = new QuickFindUF(N); //Creates a QuickfindUF instance with max size of N
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
            if(isOpen(i,j)==false){//if site isnt open it cannot be full
                return false;
            }
            //TODO check if site is in component that contains a site in top row


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

    public void populateQuickFind(){ //connects together sites that are both open if they are next to each other
        for(int i = 0; i<max-1; i++){//Horizontal Linking
            for(int j = 0; j<max; j++){
                if(isOpen(i,j)&&isOpen(i+1,j)){//if two open sites are next to each other horizontally
                    //TODO put your function here
                }
            }
        }
        for(int i = 0; i<max; i++){//Vertical Linking
            for(int j = 0; j<max-1; j++){
                if(isOpen(i,j)&&isOpen(i,j+1)){//if two open sites are next to each other vertically
                    //TODO put your function here
                }
            }
        }
    }

    public int arrayID(int y, int x) { //Convert the 2d array indices to 1d array index
        return max * (y-1) + (x-1);
    }
    
    public static void main(String args[]){
        System.out.println("Percolation Started");
        Percolation p = new Percolation(20);
        System.out.println("Percolates? " + p.percolates());

    }
}

