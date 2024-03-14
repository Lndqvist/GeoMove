import java.awt.*;

public class Circle extends GeoShapes {
    private int width, height, x, y;

    public Circle(int ix, int iy, int w, int h) {
        width = w;
        height = h;
        x = ix;
        y = iy;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean includesPoint(int pointX, int pointY) {
        int r = width / 2;
        return Math.sqrt(((pointX - x - r) * (pointX - x - r)) + ((pointY - y - r) * (pointY - y - r))) <= width / 2;
    }
}
