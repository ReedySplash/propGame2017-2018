package presentacio;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;

public class FichaGUI extends JPanel {

    private Color color;
    private Dimension dimension;
    private int diameter;
    private EventListenerList listenerList;

    //Constructors
    public FichaGUI(Color color, Dimension dimension) {
        super();
        this.color = color;
        this.dimension = dimension;
        diameter = dimension.width - 2;
        setPreferredSize(dimension);
        listenerList = new EventListenerList();
    }

    //Paint the pin on JPanel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Paint circle
        g.setColor(color);
        g.fillOval(0, 0, dimension.width - 2, dimension.height - 2);

        //Paint stroke
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, dimension.width - 2, dimension.height - 2);
    }

    public Color getColor() {
        return color;
    }
}