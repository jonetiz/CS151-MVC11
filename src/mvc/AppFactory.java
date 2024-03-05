/*
Jonathan Etiz & Luan Nguyen
AppFactory.java
Version 0
 */

package mvc;

public interface AppFactory {
    Model makeModel();
    View makeView();
    String getTitle();
    String[] getHelp();
    String about();
    String[] getEditCommands();
    Command makeEditCommand(String name);
}
