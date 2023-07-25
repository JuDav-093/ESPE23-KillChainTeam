
package ec.edu.espe.evsustore.utils;

import javax.swing.JTextField;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class TextFieldValidator {
    public static boolean isTextFieldEmpty(JTextField textField) {
        return textField.getText().trim().isEmpty();
    }
}
