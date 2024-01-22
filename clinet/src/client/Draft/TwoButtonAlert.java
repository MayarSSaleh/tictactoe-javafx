/* 
relaterd to mayar
check alert design
 */
package client.Draft;

import javax.swing.JOptionPane;

public class TwoButtonAlert {

    public static void main(String[] args) {
        // Create an instance of the class
        
        JOptionPane.showMessageDialog(
                null,                      // Parent component (null for default)
                "",  // Message to display
                "Alert",                   // Dialog title
                JOptionPane.INFORMATION_MESSAGE // Message type
        );
        
        TwoButtonAlert twoButtonAlert = new TwoButtonAlert();

        // Call the method to show the alert
//        twoButtonAlert.showAlert();
        
//        twoButtonAlert.showtext();
    }

    
     public void showtext() {
        // Display a message dialog with only text
        JOptionPane.showMessageDialog(
                null,                      // Parent component (null for default)
                "This is your alert message",  // Message to display
                "Alert",                   // Dialog title
                JOptionPane.INFORMATION_MESSAGE // Message type
        );
    }
    
    // Method to show the alert with two buttons
    public void showAlert() {
        // Display an option dialog with two buttons
        int choice = JOptionPane.showOptionDialog(
                null, // Parent component (null for default)
                "This is your alert message", // Message to display
                "Alert", // Dialog title
                JOptionPane.YES_NO_OPTION, // Option type
                JOptionPane.INFORMATION_MESSAGE, // Message type
                null, // Icon (null for default)
                new Object[]{"OK", "Cancel"}, // Options
                "OK" // Default option
        );

        // Check the user's choice
        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "You clicked OK!");
        } else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "You clicked Cancel!");
        }
    }
}

