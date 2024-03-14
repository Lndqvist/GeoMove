import java.awt.*;

abstract class GeoShapes {

    abstract public void draw(Graphics g);

    abstract public int[] getPos();

    abstract public void setPos(int x, int y);

    abstract public boolean includesPoint(int x, int y);
}
