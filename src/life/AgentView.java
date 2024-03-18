package life;

import CALab.CellView;

import javax.swing.*;
import java.awt.*;

public class AgentView extends CellView {
    public void update() {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText("" + ((Agent)myCell).ambience);
        System.out.println("" + ((Agent)myCell).ambience);
    }
}
