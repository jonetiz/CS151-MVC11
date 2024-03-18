package life;

import CALab.Cell;

import java.awt.*;
import java.util.Random;

public class Agent extends Cell {
    private int status = 0;
    public int ambience = 8;
    public void observe() {
        // update ambience
        ambience = 0;
        for (Cell neighbor : neighbors) {
            ambience += neighbor.getStatus();
        }
    }

    public Agent(Society society, int row, int col){
        myGrid = society;
        this.row = row;
        this.col = col;
    }

    public void interact() {
        // empty according to assignment
    }

    public void update() {
        //  A living cell dies if it has too few or too many living neighbors (ambience = 0, 1, 4, 5, 6, 7, 8),
        //  and a dead cell comes back to life it has 3 living neighbors
        if (Society.rebirth.contains(status)) { // if it should be reborn
            status = 1;
        } else if (Society.death.contains(status)) {
            status = 0;
        }
    }

    public void nextState() {

    }

    public void reset(boolean random) {
        if (random) {
            Random r = new Random();
            int alive = r.nextInt(100);
            if (alive < Society.percentAlive) {
                status = 1;
            } else {
                status = 0;
            }
        } else {
            status = 0;
        }
    }

    public Color getColor() {
        return (status != 0) ? Color.green : Color.red; // green if alive, red if dead
    }

    public int getStatus() {
        return status;
    }
}
