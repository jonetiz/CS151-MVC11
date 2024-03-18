package life;

import CALab.*;
import mvc.*;

public class LifeFactory extends GridFactory {
    public Model makeModel() { return new Society(); }

    public View makeView(Society model) {
        return new LifeView(model);
    }

    public String getTitle() { return "Life"; }

    public String[] getHelp() {
        return super.getHelp();
    }

    public String about() {
        return "Conway's game of life";
    }
}
