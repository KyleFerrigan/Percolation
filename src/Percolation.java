public class Percolation {

    private boolean[][] grid;//Array that holds grid of open or closed sites
    private int max;
    private QuickFindUF qFind;

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

        max = N-1; //Max size of array (minus one because arrays start at 0)
        qFind = new QuickFindUF(((max+2) * (max+1)) + (max+1)); //Creates a QuickFindUF instance with max size of N
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
            if(!isOpen(i,j)){//if site isn't open it cannot be full
                return false;
            }

            for(int k = 0; k<max; k++){
                if (qFind.connected(arrayID(i,j), arrayID(0,k))){
                    return true;
                }
            }
            return false;
        }

        catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println("Outside prescribed range");
            return false;
        }
    }

    public boolean percolates(){ //does the system percolate?
        //Check bottom sites for a site that is open, if so call isFull
        for (int i = 0; i<=max; i++) {
            if (isOpen(max,i)){ //if bottom site is open
                if(isFull(max,i)){ //if bottom site is full, this is more expensive so checking if its open first makes more sense
                    return true; //if bottom site is full it means it will percolate, no more sites need to be tested.
                }
            }
        }
        return false; //if no full sites found this will execute
    }

    public void populateQuickFind(){ //connects together sites that are both open if they are next to each other
        for(int i = 0; i<max; i++){ //Horizontal Linking
            for(int j = 0; j<max; j++){
                if(isOpen(i,j) && isOpen(i+1,j)){ //if two open sites are next to each other horizontally
                    qFind.union(arrayID(i,j), arrayID(i+1,j));
                }
            }
        }

        for(int i = 0; i<max; i++){ //Vertical Linking
            for(int j = 0; j<max; j++){
                if(isOpen(i,j) && isOpen(i,j+1)){ //if two open sites are next to each other vertically
                    qFind.union(arrayID(i,j), arrayID(i,j+1));
                }
            }
        }
    }

    public int arrayID(int x, int y) { //Convert the 2d array indices to 1d array index
        int arrID = (((max+1) * (x)) + (y));
        return arrID;
    }

    public static void main(String[] args){
        System.out.println("Percolation Started");
        Percolation p = new Percolation(20);

        //Opens a set number of sites randomly
        int max = p.max;
        int numSiteOpen = 250;//Number of sites to open
        int i = 0;
        while (i<numSiteOpen){
            int rand1 = ((int)(Math.random() * (max + 1)));
            int rand2 = ((int)(Math.random() * (max + 1)));
            if (!p.isOpen(rand1,rand2)){
                p.open(rand1,rand2);
                i++;
            }
        }

        p.populateQuickFind();

        System.out.println("Percolates? " + p.percolates());

    }
}

