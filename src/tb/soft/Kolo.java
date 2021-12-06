package tb.soft;

import java.awt.*;

public class Kolo extends Sprajt {
    private final int a = 20;

    public Kolo(int x, int y) {
        super(x, y);
    }


    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillOval(x-a/2, y-a/2, a, a);
    }
}
