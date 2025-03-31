import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton backToMainMenuButton;
    private JButton registerStudentButton;
    private JPanel main;


    public Register() {
        setContentPane(main);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 400);

        registerStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Register.this,
                        "Student registered successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        backToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (backToMainMenuButton.isSelected()){
                    dispose();
                }
                else {

                    JOptionPane.showMessageDialog(Register.this,
                            "Returning to main menu...",
                            "Info", JOptionPane.INFORMATION_MESSAGE);
                }
                new SchoolfeeSystem().setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Register().setVisible(true);
            }
        });
    }
}
