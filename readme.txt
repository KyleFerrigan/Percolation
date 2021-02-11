/******************************************************************************
 *  Name: Kyle Ferrigan
 *  NetID: kbferrigan
 *  Precept:  N/A
 *
 *  Partner Name: Patrick Galati
 *  Partner NetID: pagalati
 *  Partner Precept: N/A
 * 
 *  Operating system: Kyle: MacOS; Patrick: Win10
 *  Compiler: Kyle: JetBrains IntelliJ IDEA; Patrick: Netbeans
 *  Text editor / IDE: Kyle: JetBrains IntelliJ IDEA; Patrick: Netbeans
 *
 *  Have you taken (part of) this course before:
 *  Kyle: No; Patrick: No
 *  Hours to complete assignment (optional):
 *  8 Hours Each
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates?
 *****************************************************************************/
 We implemented it by creating a grid of booleans correlating to whether or not they are open. That way it was fast to check if they were open or closed.
  We used the QuickFind and QuickWeightedUnion to help us determine if a given site was full or not by converting the coordinates into a 1 dimensional identifier referencing if they were in the same component or not.
  If the site was in the same component as a site in the top row it is determined to be full.
  To find if it percolates we searched the bottom row for an open site and then tried to determine if it was full, if so, the system percolates.

/******************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for values of n and T when implementing
 *  Percolation.java with QuickFindUF.java.
 *
 *  To do so, fill in the two tables below. Each table must have at least
 *  4 data points, ranging in time from around 0.1 seconds to around
 *  60 seconds. Do not include data points that takes less than 0.1 seconds.
 *****************************************************************************/

(keep T constant) - 50

 n          time (seconds)
------------------------------
20          0.246 seconds
25          0.68 seconds 
40          7.929 seconds
50          22.598 seconds
...


(keep n constant) - 50

 T          time (seconds)
------------------------------
5           2.326 seconds
10          4.783 seconds
20          9.328 seconds
40          18.764 seconds
...


/******************************************************************************
 *  Using the empirical data from the above two tables, give a formula 
 *  (using tilde notation) for the running time (in seconds) of
 *  PercolationStats.java as function of both n and T, such as
 *
 *       ~ 5.3*10^-8 * n^5.0 T^1.5
 *
 *  Recall that with tilde notation, you include both the coefficient
 *  and exponents of the leading term (but not lower-order terms).
 *  Round each coefficient to two significant digits.
 *
 *****************************************************************************/

running time (in seconds) as a function of n and T:  ~ 


/******************************************************************************
 *  Repeat the previous two questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 *****************************************************************************/

(keep T constant) - 50

 n         time (seconds)
------------------------------
20         0.167 seconds
25         0.343 seconds
40         1.792 seconds
50         4.148 seconds
...


(keep n constant) - 50

 T          time (seconds)
------------------------------
5           0.477 seconds
10          0.915 seconds
20          1.761 seconds
40          3.349 seconds
...


running time (in seconds) as a function of n and T:  ~ 


/**********************************************************************
 *  How much memory (in bytes) does a Percolation object (which uses
 *  WeightedQuickUnionUF.java) use to store an n-by-n grid? Use the
 *  64-bit memory cost model from Section 1.4 of the textbook and use
 *  tilde notation to simplify your answer. Briefly justify your
 *  answers.
 *
 *  Include the memory for all referenced objects (deep memory).
 **********************************************************************/
Percolation.java
    Class-Wide Variables
        boolean[N][N] grid - N*N
        int loopmax - 4
        wqfind (WeightedQuickUnionUF.java instance)
            Class-Wide Variables
                int[n] parent - 4N+24
                int[n] size - 4N+24
                int count 4
            WeightedQuickUnionUF Constructor
                int n 4
                int i 4
            count Function
                none
            find Function
                int p 4
            connected function
                int p 4
                int q 4
            validate function
                int p 4
                int n 4
            union function
                int p 4
                int q 4
                int rootP 4
                int rootQ 4
    Percolation Constructor
        int N 4
        int i 4
        int j 4
    open Function
        int i 4
        int j 4
    isOpen Function
        int i 4
        int j 4
    isFull Function
        int i 4
        int j 4
        int k 4
    percolates Function
        int i 4
    populateQuickFind Function
        int i 4
        int j 4
    arrayID Function
        int x 4
        int y 4
        int arrID 4

Total Bytes: (N*N)+4+(4N+24)+(4N+24)+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4+4 = N^2+8N+164 bytes
 
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
No bugs known.



/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including
 *  classmates and friends) and attribute them by name.
 *****************************************************************************/
 N/A

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
   We had a roadblock trying to find the tilde notation for our program.



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/

v
