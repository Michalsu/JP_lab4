package tb.soft;

import java.awt.*;

public class Kwadrat extends Sprajt {
    private final int a = 20;

    public Kwadrat(int x, int y) {
        super(x, y);
    }


    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillRect(x-a/2, y-a/2, a, a);
    }
}
