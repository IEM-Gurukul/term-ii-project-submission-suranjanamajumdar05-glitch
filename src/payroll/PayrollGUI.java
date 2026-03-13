// UI - Swing Interface
package payroll;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PayrollGUI {
    public static void main(String[] args) {
        PayrollService service = new PayrollService();
        JFrame frame = new JFrame("Payroll Management System");
        JLabel typeLabel = new JLabel("Employee Type:");
        String types[] = {"Full Time", "Part Time"};
        JComboBox<String> typeBox = new JComboBox<>(types);
        JLabel idLabel = new JLabel("Employee ID:");
        JTextField idField = new JTextField(10);
        JLabel nameLabel = new JLabel("Employee Name:");
        JTextField nameField = new JTextField(10);
        JLabel salaryLabel = new JLabel("Monthly Salary:");
        JTextField salaryField = new JTextField(10);
        JLabel rateLabel = new JLabel("Hourly Rate:");
        JTextField rateField = new JTextField(10);
        JLabel hoursLabel = new JLabel("Hours Worked:");
        JTextField hoursField = new JTextField(10);
        JButton addButton = new JButton("Add Employee");
        JButton showButton = new JButton("Show Employees");
        JTextArea outputArea = new JTextArea(10,30);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        rateLabel.setVisible(false);
        rateField.setVisible(false);
        hoursLabel.setVisible(false);
        hoursField.setVisible(false);
        typeBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String type = (String) typeBox.getSelectedItem();
                if(type.equals("Full Time")) {
                    salaryLabel.setVisible(true);
                    salaryField.setVisible(true);
                    rateLabel.setVisible(false);
                    rateField.setVisible(false);
                    hoursLabel.setVisible(false);
                    hoursField.setVisible(false);

                } 
                else {
                    salaryLabel.setVisible(false);
                    salaryField.setVisible(false);
                    rateLabel.setVisible(true);
                    rateField.setVisible(true);
                    hoursLabel.setVisible(true);
                    hoursField.setVisible(true);
                }
                frame.revalidate();
                frame.repaint();
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    String type = (String) typeBox.getSelectedItem();
                    if(type.equals("Full Time")) {
                        double salary = Double.parseDouble(salaryField.getText());
                        FullTimeEmployee emp =new FullTimeEmployee(id, name, salary);
                        service.addEmployee(emp);
                    }
                    else {
                        double rate = Double.parseDouble(rateField.getText());
                        int hours = Integer.parseInt(hoursField.getText());
                        PartTimeEmployee emp =new PartTimeEmployee(id, name, rate, hours);
                        service.addEmployee(emp);
                    }
                    JOptionPane.showMessageDialog(frame,"Employee Added Successfully");

                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Invalid Input!");
                }
            }
        });
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                for(Employee emp : service.getEmployees()) {

                    outputArea.append("ID: " + emp.getId() +" Name: " + emp.getName() +" Salary: " + emp.calculateSalary() + "\n"
                    );
                }
                outputArea.append("\nTotal Payroll: "+ service.getTotalPayroll());
            }
        });
        frame.setLayout(new GridLayout(8,2));
        frame.add(typeLabel);
        frame.add(typeBox);
        frame.add(idLabel);
        frame.add(idField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(salaryLabel);
        frame.add(salaryField);
        frame.add(rateLabel);
        frame.add(rateField);
        frame.add(hoursLabel);
        frame.add(hoursField);
        frame.add(addButton);
        frame.add(showButton);
        frame.add(scrollPane);
        frame.setSize(420,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}