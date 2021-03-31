

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final Site[][] grid;
    private final int size;
    private int numberOfOpenSite = 0;
    private final WeightedQuickUnionUF wuf;
    private final Site topNode;
    private final Site bottomNode;


    //     creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("You must text a number > 0");
        size = n;
        grid = new Site[n][n];
//        noOfOpenSites = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = new Site(false, i * n + j);
            }
        }
        int wufList = n * n + 2;
        topNode = new Site(true, wufList - 1);
        bottomNode = new Site(true, wufList - 2);
        wuf = new WeightedQuickUnionUF(wufList);


//        topNode = grid[0][0];
//        bottomNote = grid[n + 1][0];
        //  tree top
        Site[] topRow = grid[0];
        Site[] bottomRow = grid[n - 1];

        for (Site site : topRow) {
            wuf.union(site.getIndex(), topNode.getIndex());
        }

        for (Site site : bottomRow) {
            wuf.union(site.getIndex(), bottomNode.getIndex());
        }

    }


    //   opens the site (row, col) if it is not open already
    public void open(int row, int col) {
//       Site siteBottom = grid[row + 1][col];
//        Site siteTop = grid[row - 1][col];
        Site site = grid[row][col];
        site.setSiteIsOpen(true);
        //  open at top
        if (row == 0) {
            Site siteConnerTop = grid[row + 1][col];
            if (siteConnerTop.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteConnerTop.getIndex());

            }
        }
        //  open at bottom
        else if (row == size - 1) {
            Site siteConnerBottom = grid[row - 1][col];
            if (siteConnerBottom.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteConnerBottom.getIndex());

            }
        }
        //  open at Left
        else if (col == 0) {
            //  checkBottom
            Site siteBottom = grid[row + 1][col];
            if (siteBottom.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteBottom.getIndex());

            }
            //  checkTop
            Site siteTop = grid[row - 1][col];
            if (siteTop.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteTop.getIndex());

            }
            //  Check Right
            Site siteRight = grid[row][col + 1];
            if (siteRight.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteRight.getIndex());

            }
        }
        //  Open at Right
        else if (col == size - 1) {
            //  checkBottom
            Site siteBottom = grid[row + 1][col];
            if (siteBottom.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteBottom.getIndex());

            }
            //  checkTop
            Site siteTop = grid[row - 1][col];
            if (siteTop.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteTop.getIndex());

            }
            //  check Left
            Site siteLeft = grid[row][col - 1];
            if (siteLeft.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteLeft.getIndex());

            }
        }
        //  rest
        else {
            //  checkBottom
            Site siteBottom = grid[row + 1][col];
            if (siteBottom.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteBottom.getIndex());

            }
            //  checkTop
            Site siteTop = grid[row - 1][col];
            if (siteTop.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteTop.getIndex());

            }
            //  check Left
            Site siteLeft = grid[row][col - 1];
            if (siteLeft.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteLeft.getIndex());

            }
            //  Check Right
            Site siteRight = grid[row][col + 1];
            if (siteRight.isSiteIsOpen()) {
                wuf.union(site.getIndex(), siteRight.getIndex());

            }
        }


    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        Site site = grid[row][col];
        return site.isSiteIsOpen();
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        Site site = grid[row][col];
        return wuf.find(site.getIndex()) == wuf.find(topNode.getIndex());

    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        numberOfOpenSite += 1;
        return numberOfOpenSite;
    }

    // does the system percolate?
    public boolean percolates() {

        return wuf.find(topNode.getIndex()) == wuf.find(bottomNode.getIndex());

    }


    // test client (optional)
    public static void main(String[] args) {
        System.out.println("run percolation");
    }
}

class Site {
    private boolean siteIsOpen;
    private int index;

    public Site() {
    }

    public Site(boolean siteIsOpen, int index) {
        this.siteIsOpen = siteIsOpen;
        this.index = index;
    }

    public boolean isSiteIsOpen() {
        return siteIsOpen;
    }

    public void setSiteIsOpen(boolean siteIsOpen) {
        this.siteIsOpen = siteIsOpen;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}


