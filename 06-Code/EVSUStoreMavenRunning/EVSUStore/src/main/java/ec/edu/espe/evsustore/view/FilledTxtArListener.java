
package ec.edu.espe.evsustore.view;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class FilledTxtArListener implements DocumentListener{
    ArrayList<JTextArea> fieldsToCheck;
    ArrayList<JButton> buttonsToEnable;

    public FilledTxtArListener(ArrayList<JTextArea> fieldsToCheck, ArrayList<JButton> buttonsToEnable) {
        this.fieldsToCheck = fieldsToCheck;
        this.buttonsToEnable = buttonsToEnable;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkFields();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkFields();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkFields();
    }
    
    private void checkFields(){
        boolean allFieldsValid = true;
        for(JTextArea txtToCheck: fieldsToCheck){
            if(!txtToCheck.getText().isEmpty()){
                allFieldsValid = true && allFieldsValid;
            }
            else{
                allFieldsValid = false && allFieldsValid;
            }
        }
        
        for(JButton btnToEnable: buttonsToEnable){
            btnToEnable.setEnabled(allFieldsValid);
        }
    }
}
