package life;

import CALab.*;

import java.util.HashSet;
import java.util.Set;

public class Society extends Grid {
    public static int percentAlive = 50;
    public static Set<Integer> rebirth = new HashSet<>();
    public static Set<Integer> death = new HashSet<>();

    static {
        rebirth.add(3);
        death.add(0);
        death.add(1);
        death.add(4);
        death.add(5);
        death.add(6);
        death.add(7);
        death.add(8);
    }

    public Agent makeCell(boolean uniform) {
        for(int row = 0; row < dim; row++){
            for(int col = 0; col < dim; col++){
                Cell cell = new Agent(this, row, col);
                cells[row][col] = cell;
            }
        }
        return null;
    }
}
