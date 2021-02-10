public class PercolationStats 
{
    private double[] grid;
    
    public PercolationStats(int N, int T) { // perform T independent experiments on an N-by-N grid
        try {
            //Monte Carlo Simulation
            System.out.println("Monte Carlo Simulation Started");
            //Initialize all sites to be blocked
            int gridSize=20;
            PercolationWQUF p = new PercolationWQUF(gridSize);

            //Opens a set number of sites randomly
            int numSiteOpen = 200; //Number of sites to open
            int i = 0;
            while (i<numSiteOpen){
                int rand1 = ((int)(Math.random() * (gridSize)));
                int rand2 = ((int)(Math.random() * (gridSize)));
                if (!p.isOpen(rand1,rand2)){
                    p.open(rand1,rand2);
                    i++;
                }
            }
            System.out.println(numSiteOpen + " Sites opened");

            p.populateQuickFind();//Populates QuickFindArray

            System.out.println("Percolates? " + p.percolates());
            //Monte Carlo Simulation End
        }

        catch (java.lang.IllegalArgumentException e) {
            if (N<=0) {
                System.out.println("N cannot be less than or equal to 0");
            }
            if (T<=0) {
                System.out.println("T cannot be less than or equal to 0");
            }
        }
    }

    public double mean()
    { //sample mean of percolation threshold
        return -1; //placeholder
    }

    public double stddev()
    { //sample standard deviation of percolation threshold

        return -1;//placeholder
    }

    public double confidenceLow()
    { //low  endpoint of 95% confidence interval

        return -1;//placeholder
    }

    public double confidenceHigh()
    { //high endpoint of 95% confidence interval

        return -1; //placeholder
    }

    public static void main(String[] args){
        int numTests = 100;
        int gridSize = 20;
        PercolationStats perfStats = new PercolationStats(gridSize,numTests);
    }
}
