import javax.swing.*;

public class GeoMove extends JFrame {

    public GeoMove() {
        add(new GeoPanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GeoMove frame = new GeoMove();
    }

}
