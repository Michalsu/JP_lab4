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


        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnRunButton = new JButton("Run");
        btnRunButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (e.getX() <= btnRunButton.getWidth()-10 && e.getY()<= btnRunButton.getHeight() ) {
                    btnRunButton.setLocation(getRandomNumber(0, contentPane.getWidth() - btnRunButton.getWidth()), getRandomNumber(0, contentPane.getHeight() - btnRunButton.getHeight()));
                }
            }
        });
        contentPane.add(btnRunButton);
        btnRunButton.setBounds(160,70, 60,20);


        JButton cancelButton = new JButton("Anuluj");
        contentPane.add(cancelButton);
        cancelButton.setBounds(60, 70, 80, 20);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRunButton.setLocation(160,70);
            }
        });


    }}
