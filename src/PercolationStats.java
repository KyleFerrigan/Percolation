public class PercolationStats {
    
    public PercolationStats(int N, int T) { // perform T independent experiments on an N-by-N grid
        try {
            int[] minPerc = new int[T+1];
            for (int i = 0; i<T; i++){
                boolean perc = false;
                for (int j = 1; !perc; j++){//go through
                    //Monte Carlo Simulation

                    //Initialize all sites to be blocked
                    PercolationWQUF p = new PercolationWQUF(N);

                    //Opens a set number of sites randomly
                    int numSiteOpen = j; //Number of sites to open

                    int k = 0;
                    while (k<numSiteOpen){//opens up random
                        int rand1 = ((int)(Math.random() * (N)));
                        int rand2 = ((int)(Math.random() * (N)));
                        if (!p.isOpen(rand1,rand2)){
                            p.open(rand1,rand2);
                            k++;
                        }
                    }

                    p.populateQuickFind();//Populates QuickFindArray

                    if(p.percolates()){
                        minPerc[i] = j;
                        perc=true;
                    }
                    //Monte Carlo Simulation End
                }

            }
            for (int l=0;l<T;l++){
                System.out.println(minPerc[l]);
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

    public double mean(){ //sample mean of percolation threshold
        return -1; //placeholder
    }

    public double stddev(){ //sample standard deviation of percolation threshold
        return -1;//placeholder
    }

    public double confidenceLow(){ //low  endpoint of 95% confidence interval

        return -1;//placeholder
    }

    public double confidenceHigh(){ //high endpoint of 95% confidence interval

        return -1; //placeholder
    }

    public static void main(String[] args){
        int numTests = 100;
        int gridSize = 20;
        PercolationStats perfStats = new PercolationStats(gridSize,numTests);
    }
}
