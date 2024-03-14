import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class GeoPanel extends JPanel implements MouseMotionListener, MouseListener {
    private LinkedList<GeoShapes> order = new LinkedList<>();
    private GeoShapes current;
    private int dx, dy;

    public GeoPanel() {
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(700, 450));
        addMouseMotionListener(this);
        addMouseListener(this);
        GeoShapes square = new Square(75, 75, 100, 100);
        GeoShapes circle = new Circle(100, 100, 100, 100);
        GeoShapes triangle = new Triangle(new int[]{550, 500, 600},
                new int[]{100, 200, 200}, 100, 100);
        order.add(square);
        order.add(circle);
        order.add(triangle);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GeoShapes shape : order) {
            shape.draw(g);
        }
    }

    public void mousePressed(MouseEvent e) {
        current = null;
        int x = e.getX();
        int y = e.getY();
        if (order.get(2).includesPoint(x, y)) current = order.get(2);
        else if (order.get(1).includesPoint(x, y)) {
            current = order.get(1);
            order.remove(current);
            order.addLast(current);
        } else if (order.get(0).includesPoint(x, y)) {
            current = order.get(0);
            order.remove(current);
            order.addLast(current);
        }
        dx = x;
        dy = y;

    }

    public void mouseDragged(MouseEvent e) {
        if (current != null) {
            int[] currPos = current.getPos();
            int x = currPos[0] + e.getX() - dx;
            int y = currPos[1] + e.getY() - dy;
            current.setPos(x, y);
            dx = e.getX();
            dy = e.getY();
            repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
