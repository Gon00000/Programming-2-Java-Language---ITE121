import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolfeeSystem extends JFrame{
    private JButton registerNewStudentButton;
    private JButton recordPaymentButton;
    private JButton viewStudentRecordButton;
    private JButton generateReceiptButton;
    private JButton calculateOverdueBalancesButton;
    private JButton exitButton;
    private JPanel main;

    public SchoolfeeSystem() {
        setTitle("School Fee System");
        setContentPane(main);
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        registerNewStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(registerNewStudentButton.isSelected()){

                }
                else {
                    new Register().setVisible(true);
                }

            }
        });
        recordPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(recordPaymentButton.isSelected()) {
                }else {
                    new Record().setVisible(true);

                }
            }
        });
        viewStudentRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(viewStudentRecordButton.isSelected()){

                }
            }
        });
        generateReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(generateReceiptButton.isSelected()){

                }
            }
        });
        calculateOverdueBalancesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(calculateOverdueBalancesButton.isSelected()){

                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        SchoolfeeSystem.this,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    dispose(); // or System.exit(0)
                }

                if(exitButton.isSelected()) {
                }
                else {
                    JOptionPane.showMessageDialog(null, "Thank you for visiting");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new SchoolfeeSystem().setVisible(true);
            }
        });
    }
}
