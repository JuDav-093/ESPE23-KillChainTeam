
package ec.edu.espe.evsustore.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class ButtonGroupListener implements ActionListener{
    ArrayList<JRadioButton> buttons;
    JButton buttonToEnable;

    public ButtonGroupListener(ArrayList<JRadioButton> buttons, JButton buttonToEnable) {
        this.buttons = buttons;
        this.buttonToEnable = buttonToEnable;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isOneSelected = false;
        for(JRadioButton btn : buttons){
            if(btn.isSelected()){
                isOneSelected = true;
            }
        }
        buttonToEnable.setEnabled(isOneSelected);
    }
    
    
}
