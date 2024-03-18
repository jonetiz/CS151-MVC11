package life;

import CALab.Cell;

import java.awt.*;

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

    public void interact() {
        // empty according to assignment
    }

    public void update() {
        //  A living cell dies if it has too few or too many living neighbors (ambience = 0, 1, 4, 5, 6, 7, 8),
        //  and a dead cell comes back to life it has 3 living neighbors
        if (status == 0) { // if it's dead
            if (ambience >= 3) {
                status = 1; // bring back to life when it has 3 living neighbors
            }
        } else {
            if (ambience != 2 && ambience != 3) {
                status = 0; // cell dies when ambience is not 2 or 3
            }
        }
    }

    public void nextState() {

    }

    public void reset(boolean randomly) {

    }

    public Color getColor() {
        return null;
    }

    public int getStatus() {
        return status;
    }
}
