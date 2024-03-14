import java.awt.*;

public class Triangle extends GeoShapes {
    private int[] xp, yp;
    private int w, h;

    public Triangle(int[] xp, int[] yp, int w, int h) {
        this.xp = xp;
        this.yp = yp;
        this.w = w;
        this.h = h;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillPolygon(xp, yp, 3);
    }

    public int[] getPos() {
        return new int[]{xp[1], yp[0]};
    }

    @Override
    public void setPos(int x, int y) {
        xp[0] = x + w / 2;
        xp[1] = x;
        xp[2] = x + w;
        yp[0] = y;
        yp[1] = y + h;
        yp[2] = y + h;
    }

    public boolean includesPoint(int pointX, int pointY) {
        int dx = pointX - xp[0];
        int dy = pointY - yp[0];
        return -dy <= 2 * dx && 2 * dx <= dy && dy <= h;
    }

}
