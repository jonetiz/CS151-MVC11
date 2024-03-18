package CALab;

import java.util.*;

import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() {
        return dim;
    }

    public int getTime() {
        return time;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public abstract Cell makeCell(boolean uniform);


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }

    public Grid() {
        this(20);
    }

    protected void populate() {
        // 1. use makeCell to fill in cells
        // 2. use getNeighbors to set the neighbors field of each cell
        makeCell(true);
        for(Cell[] row : cells){
            for(Cell cell : row){
                cell.neighbors = getNeighbors(cell, 1);
            }
        }

    }

    // called when Populate and clear buttons are clicked
    public void repopulate(boolean randomly) {
//        if (randomly) {
//            // randomly set the status of each cell
//        } else {
//            // set the status of each cell to 0 (dead), i.e. initial value
//        }
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.reset(randomly);
            }
        }
        // notify subscribers
        notifySubscribers();
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */

        // if the radius is 1 we just need the neighbors
        //if (radius == 1) return asker.neighbors;
        // this will be returned
        Set<Cell> set = new HashSet<>();
        // recursively add all neighbors to set
        //for (Cell neighbor : asker.neighbors) {
            //set.addAll(getNeighbors(neighbor, radius - 1));
        //}
        /*
                +---+---+---+
                | 1 | 2 | 3 |
                +---+---+---+
                | 5 | 6 | 7 |
                +---+---+---+
                | 9 |10 |11 |
                +---+---+---+
        */
        int askerRow = asker.row;
        int askerCol = asker.col;

        //starting topleft, ending bottonright
        int row = askerRow-radius;//starting row
        int col = askerCol-radius;//starting col

        while(row <= askerRow+radius){//ending row
            while(col <= askerCol+radius){//ending col

                int r = (int) (row - dim*(Math.floor((double) row /(double)dim)));
                int c = (int) (col - dim*(Math.floor((double) col /(double)dim)));
                Cell cell = getCell(r,c);
                if(cell.equals(asker)) continue;
                set.add(cell);

                col++;
            }
            row++;
        }

        return set;
    }


    // cell phases:

    public void observe() {
        // call each cell's observe method and notify subscribers
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.observe();
                cell.notifySubscribers();
            }
        }
        notifySubscribers();
    }

    public void interact() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.interact();
                cell.notifySubscribers();
            }
        }
        notifySubscribers();
    }

    public void update() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.update();
                cell.notifySubscribers();
            }
        }
        notifySubscribers();
    }

    public void updateLoop(int cycles) {
        observe();
        for (int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}