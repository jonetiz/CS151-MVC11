package CALab;

import mvc.Command;
import mvc.Model;
import stopLight.Stoplight;

public class RunCommand extends Command {
    private int runCount;
    public RunCommand(Model model, int runCount) {
        super(model);
        this.runCount = runCount;
    }

    public void execute() {
        Grid grid = (Grid)model;
        grid.updateLoop(runCount);
    }
}
