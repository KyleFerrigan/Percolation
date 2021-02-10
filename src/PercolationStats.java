public class PercolationStats 
{
    private double[] grid;
    
    public PercolationStats(int N, int T)
    { // perform T independent experiments on an N-by-N grid
        try {
            grid = new double [T];
            for(int i=0; i<T; i++) {
                Percolation p = new Percolation(N);

                }
            }
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
}
