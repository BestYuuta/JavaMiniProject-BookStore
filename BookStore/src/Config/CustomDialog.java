package Config;

import java.awt.*;
import javax.swing.*;

public class CustomDialog {
    public static void show(Boolean status, String message) {
        EventQueue.invokeLater(() ->
                JOptionPane.showMessageDialog(
                        null,
                        message,
                        status ? "Information" : "Error",
                        status ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE
                )
        );
    }
}