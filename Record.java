import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;


public class Record extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JPanel main;
    private JButton button1;
    private JPanel infopanel;
    private Map<String, Student> studentDatabase;

    public Record() {
        initializeDatabase();
        setTitle("Record Payment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setContentPane(main);
        JPanel inputPanel = createInputPanel();
        infopanel = new JPanel();
        infopanel.setLayout(new GridLayout(0, 2, 5, 5));
        infopanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(infopanel), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Student Lookup"));

        panel.add(new JLabel("Student ID:"));
        textField1 = new JTextField(15);
        panel.add(textField1);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this::searchStudent);
        panel.add(searchButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearDisplay());
        button1.add(clearButton);

        return button1;
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Cash");
        comboBox.addItem("Credit-card");
        comboBox.addItem("Option 3");
        comboBox1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String selected = (String) cb.getSelectedItem();
                System.out.println("Selected: " + selected);
            }

        });
    }

    private void searchStudent(ActionEvent e) {
        String id = textField1.getText().trim();
        if (id.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please enter a student ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Student student = studentDatabase.get(id);
        if (student != null) {
            displayStudentInfo(student);
        } else {
            JOptionPane.showMessageDialog(this, "No student found with ID: " + id, "Not Found", JOptionPane.WARNING_MESSAGE);
        }


    }

    private void displayStudentInfo(Student student) {
        infopanel.removeAll();


        addInfoLabel("Student ID:", student.getId());

        addInfoLabel("Full Name:", student.getName());

        addInfoLabel("Date of Birth:", student.getDob());

        addInfoLabel("Gender:", student.getGender());

        // Academic Information
        addInfoLabel("Department:", student.getDepartment());
        addInfoLabel("Program:", student.getProgram());
        addInfoLabel("Current Semester:", student.getSemester());
        addInfoLabel("GPA:", student.getGpa());

        // Financial Information
        addInfoLabel("Total Fees:", "$" + student.getTotalFees());
        addInfoLabel("Paid Fees:", "$" + student.getPaidFees());
        addInfoLabel("Due Fees:", "$" + (student.getTotalFees() - student.getPaidFees()));
        addInfoLabel("Payment Status:", student.getPaymentStatus());

        // Contact Information
        addInfoLabel("Email:", student.getEmail());
        addInfoLabel("Phone:", student.getPhone());
        addInfoLabel("Address:", student.getAddress());

        infopanel.revalidate();
        infopanel.repaint();

    }

    private void addInfoLabel(String label, String value) {
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Arial", Font.BOLD, 12));
        infopanel.add(lbl);

        JLabel val = new JLabel(value != null ? value : "N/A");
        val.setFont(new Font("Arial", Font.PLAIN, 12));
        infopanel.add(val);
    }

    private void clearDisplay() {
        textField1.setText("");
        infopanel.removeAll();
        infopanel.revalidate();
        infopanel.repaint();


        private void initializeDatabase(){
            studentDatabase = new HashMap<>();

            studentDatabase.put("S1001", new Student(
                    "S1001", "John Doe", "1999-05-15", "Male",
                    "Computer Science", "BSc CS", "5", "3.75",
                    2500.00, 2000.00,
                    "john.doe@university.edu", "555-0101", "123 Campus Ave"));

            studentDatabase.put("S1002", new Student(
                    "S1002", "Jane Smith", "2000-02-20", "Female",
                    "Electrical Engineering", "BSc EE", "4", "3.92",
                    2700.00, 2700.00,
                    "jane.smith@university.edu", "555-0102", "456 University St"));

            studentDatabase.put("S1003", new Student(
                    "S1003", "Alex Johnson", "1998-11-08", "Male",
                    "Business Administration", "MBA", "2", "3.65",
                    3200.00, 1500.00,
                    "alex.j@university.edu", "555-0103", "789 College Blvd"));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Record().setVisible(true);

            }
        });

    }

    class Student {
        private String id;
        private String name;
        private String dob;
        private String gender;
        private String department;
        private String program;
        private String semester;
        private String gpa;
        private double totalFees;
        private double paidFees;
        private String email;
        private String phone;
        private String address;

        public Student(String id, String name, String dob, String gender,
                       String department, String program, String semester, String gpa,
                       double totalFees, double paidFees,
                       String email, String phone, String address) {
            this.id = id;
            this.name = name;
            this.dob = dob;
            this.gender = gender;
            this.department = department;
            this.program = program;
            this.semester = semester;
            this.gpa = gpa;
            this.totalFees = totalFees;
            this.paidFees = paidFees;
            this.email = email;
            this.phone = phone;
            this.address = address;
        }

        // Getters
        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDob() {
            return dob;
        }

        public String getGender() {
            return gender;
        }

        public String getDepartment() {
            return department;
        }

        public String getProgram() {
            return program;
        }

        public String getSemester() {
            return semester;
        }

        public String getGpa() {
            return gpa;
        }

        public double getTotalFees() {
            return totalFees;
        }

        public double getPaidFees() {
            return paidFees;
        }

        public String getPaymentStatus() {
            if (paidFees >= totalFees) return "Paid in Full";
            else if (paidFees == 0) return "Not Paid";
            else return "Partial Payment";
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getAddress() {
            return address;
        }
    }}