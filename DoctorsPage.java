import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoctorsPage extends JFrame {

    private JPanel contentPane;

    public DoctorsPage() {
        setTitle("Doctor Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 400);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                ImageIcon imageIcon = new ImageIcon("doctor_background.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setLayout(null); // Use absolute layout
        setContentPane(contentPane);

        // Create sign out button
        JButton signOutButton = new JButton("Sign Out");
        signOutButton.setBounds(650, 10, 120, 30);
        contentPane.add(signOutButton);
        signOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current DoctorPage window
                dispose();
                // Open the login page
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });

        // Create time slot buttons
        String[] timeSlots = {"5PM - 6PM", "6PM - 7PM", "7PM - 8PM"};
        int yPos = 50; // Initial y-position for time slot buttons
        for (String timeSlot : timeSlots) {
            JButton timeSlotButton = new JButton(timeSlot);
            timeSlotButton.setBounds(50, yPos, 150, 30);
            contentPane.add(timeSlotButton);
            yPos += 40; // Increment y-position for the next button
        }

        // Create "Available Wards" button
        JButton availableWardsButton = new JButton("Available Wards");
        availableWardsButton.setBounds(50, 300, 150, 30);
        contentPane.add(availableWardsButton);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DoctorsPage frame = new DoctorsPage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}