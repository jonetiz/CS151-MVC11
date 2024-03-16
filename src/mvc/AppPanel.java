/*
Jonathan Etiz & Luan Nguyen
AppPanel.java
Version 0
 */

package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppPanel extends JPanel implements ActionListener {
    protected View view;
    protected Model model;
    protected AppFactory factory;

    protected ControlPanel controlPanel;
    protected JFrame frame;

    public AppPanel(AppFactory factory){
        this.factory = factory;
        model = factory.makeModel();
        view = factory.makeView(model);
        controlPanel = new ControlPanel();
        this.add(controlPanel);
        this.add(view);
        this.setLayout((new GridLayout(1, 2)));

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(500, 300);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();

        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);


        return result;
    }

    public void display(){
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        System.out.println(cmmd);
        try {
            switch (cmmd) {
                case "Save": {
                    Utilities.save(model, true);
                    break;
                }

                case "Open": {
                    Utilities.open(model);
                    break;

                }

                case "New": {
                    model = factory.makeModel();
                    view.setModel(model);
                    break;
                }

                case "Quit": {
                    System.exit(0);
                    break;
                }

                case "About": {
                    Utilities.inform(factory.about());
                    break;
                }

                case "Help": {
                    Utilities.inform(factory.getHelp());
                    break;

                }

                default: {
                    factory.makeEditCommand(model, cmmd, this).execute();
                }
            }
        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }

    protected class ControlPanel extends JPanel {
        public ControlPanel() {

        }
    }
}