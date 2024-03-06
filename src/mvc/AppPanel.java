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
        //NEED WORK HERE
        return result;
    }

    public void display(){
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    }

    public class ControlPanel extends JPanel {
        public ControlPanel() {

        }
    }
}
