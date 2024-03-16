package CALab;

import mvc.*;
import stopLight.ChangeCommand;

public class GridFactory implements AppFactory {
    public Model makeModel() {return null;}

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
        return new String[] {"Run1", "Run50", "Populate", "Clear"};
    }

    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type) {
            case "Run1": {
                return new RunCommand(model, 1);
            }
            case "Run50": {
                return new RunCommand(model, 50);

            }
            case "Populate": {
                return new PopulateCommand(model);
            }
            case "Clear": {
                return new ClearCommand(model);
            }
            default: {
                return null;
            }
        }
    }
}
