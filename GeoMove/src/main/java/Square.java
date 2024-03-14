import java.awt.*;

public class Square extends GeoShapes {
    private int width, height, x, y;

    public Square(int ix, int iy, int w, int h) {
        width = w;
        height = h;
        x = ix;
        y = iy;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public int[] getPos() {
        return new int[]{x, y};
    }


    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean includesPoint(int pointX, int pointY) {
        return pointX >= x && pointX <= x + width && pointY >= y && pointY <= y + height;
    }
}
