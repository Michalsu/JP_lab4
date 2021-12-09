package tb.soft;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class MainWindow extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }




    public MainWindow() throws HeadlessException {
        this("Uciekajacy klawisz");
    }


    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public MainWindow(String title) throws HeadlessException {
        super(title);


        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Kanwa rysunek = new Kanwa();
        rysunek.setBounds(10,10,570,350);
        contentPane.add(rysunek);
        rysunek.setVisible(false);

        JTextArea instrukcja = new JTextArea("Gra w uciekajacy przycisk:\n" +
                                                "Nalezy wcisnac przycisk Run, jezeli sie to uda nagroda bedzie kanwa do rysowania\n"+
                                                "Kanwa:\n"+
                                                "k - zmiana obiektu na kwadrat\n"+
                                                "o - zmiana obiektu na kolo\n"+
                                                "lewy przycisk myszy - narysuj w tym miejscu\n"+
                                                "prawy przycisk myszy - usun aktywny obiekt z tego miejsca\n"+
                                                "(\"Bezpieczna\" strefa prycisku Run jest z prawej strony)");
        instrukcja.setBounds(10,10,500,200);
        instrukcja.setEditable(false);
        contentPane.add(instrukcja);

        JButton btnRunButton = new JButton("Run");
        btnRunButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (e.getX() <= btnRunButton.getWidth()-10 && e.getY()<= btnRunButton.getHeight() ) {
                    btnRunButton.setLocation(getRandomNumber(0, contentPane.getWidth() - btnRunButton.getWidth()), getRandomNumber(contentPane.getHeight()/2, contentPane.getHeight() - btnRunButton.getHeight()));
                }
            }
        });
        btnRunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rysunek.setVisible(true);
                btnRunButton.setVisible(false);
                instrukcja.setLocation(10, 400);
            }
        });
        contentPane.add(btnRunButton);
        btnRunButton.setBounds(160,370, 60,20);



        JButton cancelButton = new JButton("Anuluj");
        contentPane.add(cancelButton);
        cancelButton.setBounds(60, 370, 80, 20);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRunButton.setLocation(160,370);
                rysunek.setVisible(false);
                btnRunButton.setVisible(true);
                instrukcja.setLocation(10,10);
            }
        });




    }}
