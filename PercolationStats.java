import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    //    private static final int COUNT_TRIALS = 89;
    private static final double CONFIDENCE_95 = 1.96;
    private final double[] arrayOfOpenSites;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        arrayOfOpenSites = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation per = new Percolation(n);
            int row;
            int col;
            while (!per.percolates()) {
                row = StdRandom.uniform(n);
                col = StdRandom.uniform(n);

                System.out.println("random row " + row);
                System.out.println("random col " + col);
                //  open yet
                if (!per.isOpen(row, col)) {
                    per.open(row, col);
                    per.numberOfOpenSites();
//                    System.out.println("open a site and check percolate");
                }
                // open already
            }
            arrayOfOpenSites[i] = per.numberOfOpenSites();
//            numberOfOpenSiteStat += arrayOfOpenSites[i];

        }
//        System.out.println("Number of open site" + numberOfOpenSiteStat);
    }

    // sample mean of percolation threshold
    public double mean() {
//        StdStats.mean();
//        double x = 0;
//        x = numberOfOpenSiteStat / COUNT_TRIALS;
//        return x;

        return StdStats.mean(arrayOfOpenSites);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
//        double s2 = 0;
//
//        double d = 0;
//        for (double arrayOfOpenSite : arrayOfOpenSites) {
//
//            d += (arrayOfOpenSite - mean());
//
//        }
//        s2 = d / (arrayOfOpenSites.length - 1);
////        s = s2 / 2;
//        return s2;
        return StdStats.stddev(arrayOfOpenSites);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (CONFIDENCE_95 * stddev() / Math.sqrt(arrayOfOpenSites.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() - (CONFIDENCE_95 * stddev() / Math.sqrt(arrayOfOpenSites.length));
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats perStat = new PercolationStats(3, 89);
        System.out.println("Estimate of per " + perStat.mean());
        System.out.println("sample standard deviation of percolation threshold " + perStat.stddev());
        System.out.println("low" + perStat.confidenceLo());
        System.out.println("High " + perStat.confidenceHi());
    }
}
