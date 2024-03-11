/*
Jonathan Etiz & Luan Nguyen
View.java
Version 0
 */

package mvc;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class View extends JPanel implements Subscriber {
    protected Model model;
    public View(Model model){
        this.model = model;
        model.subscribe(this);
        setSize(500, 500);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setBackground(Color.LIGHT_GRAY);
    }
    public void update() {
        repaint();
    }

    public void setModel(Model model){
        this.model.unsubscribe(this);
        this.model = model;
        model.subscribe(this);
        repaint();
    }

    public void paintComponent(Graphics gc) {

    }
}
