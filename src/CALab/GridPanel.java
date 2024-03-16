package CALab;

import mvc.AppFactory;
import mvc.AppPanel;
import stopLight.StoplightFactory;
import stopLight.StoplightPanel;

import javax.swing.*;

public class GridPanel extends AppPanel {
    private JButton run1;
    private JButton run50;
    private JButton populate;
    private JButton clear;
    public GridPanel(GridFactory factory) {
        super(factory);
        run1 = new JButton("Run1");
        run1.addActionListener(this);
        run50 = new JButton("Run50");
        run50.addActionListener(this);
        populate = new JButton("Populate");
        populate.addActionListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(this);

        controlPanel.add(run1);
        controlPanel.add(run50);
        controlPanel.add(populate);
        controlPanel.add(clear);
    }

}
