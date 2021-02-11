public class PercolationStats {
    int[] minPerc;
    public PercolationStats(int N, int T) { // perform T independent experiments on an N-by-N grid
        try {
            minPerc = new int[T+1];
            for (int i = 0; i<T; i++){//run this many tests
                boolean perc = false;//this value is true if the loop below has percolated, resets on every loop above
                for (int j = 1; !perc; j++){//Keep incrementing the number of sites open until it percolates

                    //Initialize all sites to be blocked
                    PercolationWQUF p = new PercolationWQUF(N);//Set this to target Quickfind or WeightedQuickUnion

                    //Opens a set number of sites randomly
                    int numSiteOpen = j; //Number of sites to open

                    int k = 0;
                    while (k<numSiteOpen){//opens up random sites, but only if they are closed, will not open any site already open
                        int rand1 = ((int)(Math.random() * (N)));
                        int rand2 = ((int)(Math.random() * (N)));
                        if (!p.isOpen(rand1,rand2)){
                            p.open(rand1,rand2);
                            k++;
                        }
                    }

                    p.populateQuickFind();//Populates QuickFindArray or WeightedQuickUnion depending on what is set above.

                    if(p.percolates()){
                        minPerc[i] = j;//sets the min value it took to percolate
                        perc=true;//sentinel value, breaks loop
                    }

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
        int total = 0;
        double mean = 0.0;
        for(int i = 0; i< minPerc.length;i++){
            total = total + minPerc[i];
        }
        mean = total/(minPerc.length - 1.0);
        return mean;
    }

    public double stddev(){ //sample standard deviation of percolation threshold
        return -1;//placeholder todo remove
    }

    public double confidenceLow(){ //low  endpoint of 95% confidence interval

        return -1;//placeholder todo remove
    }

    public double confidenceHigh(){ //high endpoint of 95% confidence interval

        return -1; //placeholder todo remove
    }

    public static void main(String[] args){
        int numTests = 100;
        int gridSize = 20;
        PercolationStats perfStats = new PercolationStats(gridSize,numTests);
        System.out.println("Mean: "+perfStats.mean());
    }
}
