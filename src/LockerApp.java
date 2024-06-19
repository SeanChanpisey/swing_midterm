import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApp extends JFrame {
    private JTextField passwordField;
    private JLabel statusLabel;
    private String savedPassword = null;

    public LockerApp() {
        setTitle("Lock Class");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the password field
        passwordField = new JTextField();
        passwordField.setColumns(10);

        // Create the status label
        statusLabel = new JLabel(" ");

        // Create the enter button
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEnterButton();
            }
        });

        // Create the clear button
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setText("");
            }
        });

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clearButton);
        buttonPanel.add(enterButton);

        // Create a panel for the status label
        JPanel statusPanel = new JPanel();
        statusPanel.add(statusLabel);

        // Add components to the frame
        add(passwordField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
    }

    private void handleEnterButton() {
        String inputPassword = passwordField.getText();
        if (savedPassword == null) {
            savedPassword = inputPassword;
            statusLabel.setText("Password Set");
        } else {
            if (inputPassword.equals(savedPassword)) {
                statusLabel.setText("Correct Password");
            } else {
                statusLabel.setText("Incorrect Password");
            }
        }
        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LockerApp app = new LockerApp();
                app.setVisible(true);
            }
        });
    }
}
