package CALab;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class GridFactory implements AppFactory {
    public Model makeModel() {
        return null;
    }

    public View makeView(Model model) {
        return new GridView(model);
    }

    public String getTitle() { return "CALab"; }

    public String[] getHelp() {
        return new String[0];
    }

    public String about() {
        return null;
    }

    public String[] getEditCommands() {
        return new String[0];
    }

    public Command makeEditCommand(Model model, String type, Object source) {
        return null;
    }
}
