package life;

import CALab.GridFactory;
import mvc.*;

public class LifeFactory extends GridFactory {
    public Model makeModel() { return new Society(); }

    public String getTitle() { return "Life Lab"; }

    public String[] getHelp() {
        return super.getHelp();
    }

    public String about() {
        return "Conway's game of life";
    }
}
