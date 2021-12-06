package tb.soft;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Kanwa extends JPanel implements MouseInputListener {

    ArrayList<Kwadrat> Kwadraty = new ArrayList<>();
    ArrayList<Kolo> Kola = new ArrayList<>();
    int rodzajObiektu = 1; // 1 - kwadrat, 2 - kolo
    public Kanwa(){
        setBackground(Color.ORANGE);
        setLayout(null);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyChar() == 'k'){
                    rodzajObiektu = 1;
                }
                if(e.getKeyChar() == 'o'){
                    rodzajObiektu = 2;
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(rodzajObiektu == 1){
                    Kwadraty.add(new Kwadrat(e.getX(),e.getY()));
                }

                if(rodzajObiektu == 2){
                    Kola.add(new Kolo(e.getX(),e.getY()));
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        try {
            if(!Kwadraty.isEmpty()){

            }
            if(!Kola.isEmpty()){

            }
            g2d.setColor(Color.BLUE);
        } finally {
            g2d.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
