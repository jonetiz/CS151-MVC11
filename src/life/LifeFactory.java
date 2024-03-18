package life;

import CALab.*;
import mvc.*;

public class LifeFactory extends GridFactory {
    public Model makeModel() { return new Society(); }

    public View makeView(Model model) {
        return new LifeView(model);
    }

    public String getTitle() { return "CALab"; }

    public String[] getHelp() {
        return new String[0];
    }

    public String about() {
        return "Conway's game of life";
    }
}
