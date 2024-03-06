/*
Jonathan Etiz & Luan Nguyen
AppFactory.java
Version 0
 */

package mvc;

public interface AppFactory {
    abstract Model makeModel();
    abstract View makeView(Model model);
    abstract String getTitle();
    abstract String[] getHelp();
    abstract String about();
    abstract String[] getEditCommands();
    abstract Command makeEditCommand(Model model, String type, Object source);
}
