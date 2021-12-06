package tb.soft;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
        this("System logowania");
    }

    public MainWindow(String title) throws HeadlessException {
        super(title);

        HashMap<String, String> users= new HashMap<>();

        users.put("Adam123","12345678");
        users.put("Karlos","87654321");
        users.put("Papuga","abcdefgh");
        users.put("Mleko12","abc123456");
        users.put("Salsa9","qwertyuyiop");
        users.put("Perla7","Muszelka1");
        users.put("Bialko3","123487654");
        users.put("Kretyna","11111111");
        users.put("Kawosz","99999999");

        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nameLabel = new JLabel("Nazwa użytkownika: ");
        nameLabel.setBounds(10,10,140,20);
        contentPane.add(nameLabel);

        JLabel passLabel = new JLabel("Hasło: ");
        passLabel.setBounds(90,40,140,20);
        contentPane.add(passLabel);

        JTextField loginField= new JTextField(20);
        loginField.setBounds(140,10,100,20);
        contentPane.add(loginField);

        JPasswordField passField = new JPasswordField(20);
        passField.setBounds(140, 40, 100, 20);
        contentPane.add(passField);

        JButton loginButton= new JButton("Zaloguj");
        contentPane.add(loginButton);
        loginButton.setBounds(150,70, 80, 20);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(users.containsKey(loginField.getText().toString())){
                    if(users.get(loginField.getText().toString()).equals(new String(passField.getPassword()))){
                        contentPane.setBackground(Color.GREEN);
                    }else {
                        contentPane.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(new JFrame(), "Błędne hasło", "Błędne hasło",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    contentPane.setBackground(Color.RED);
                    JOptionPane.showMessageDialog(new JFrame(), "Nie ma takiego użytkownika w bazie", "Brak użytkownika",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton cancelButton = new JButton("Anuluj");
        contentPane.add(cancelButton);
        cancelButton.setBounds(60,70, 80, 20);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.setBackground(Color.LIGHT_GRAY);
                loginField.setText("");
                passField.setText("");
            }
        });

        JButton registerButton = new JButton(("Zarejestruj się"));
        contentPane.add(registerButton);
        registerButton.setBounds(90,100,120,20);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!loginField.getText().equals("") && !users.containsKey(loginField.getText())){
                    if(passField.getPassword().length>7){
                        users.put(loginField.getText(),new String(passField.getPassword()));
                        JOptionPane.showMessageDialog(new JFrame(), "Rejestracja przebiegła pomyślnie", "Utworzono konto",
                                JOptionPane.PLAIN_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(new JFrame(), "Hasło musi być długie na przynajmniej 8 znaków", "Błąd przy tworzeniu konta",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Użytkownik o tej nazwie już istnieje", "Błąd przy tworzeniu konta",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }





}
