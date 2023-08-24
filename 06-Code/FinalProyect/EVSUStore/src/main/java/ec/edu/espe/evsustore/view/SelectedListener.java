
package ec.edu.espe.evsustore.view;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class SelectedListener implements ListSelectionListener{

    ArrayList<JButton> buttonsToEnableInSelection;
    JSpinner spinner;
    JTable table;

    public SelectedListener(ArrayList<JButton> buttonsToEnableInSelection) {
        this.buttonsToEnableInSelection = buttonsToEnableInSelection;
    }
    
    public SelectedListener(ArrayList<JButton> buttonsToEnableInSelection, JSpinner spinner, JTable table){
        this.buttonsToEnableInSelection = buttonsToEnableInSelection;
        this.spinner = spinner;
        this.table = table;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        for(JButton button : buttonsToEnableInSelection){
            button.setEnabled(true);
        }
        
        if(spinner!=null){
            int rowIndex = table.getSelectedRow();
            int maxQuantity = Integer.parseInt(table.getValueAt(rowIndex, 1).toString());
            SpinnerNumberModel numberModel = new SpinnerNumberModel (1, 1, maxQuantity, 1); 
            spinner.setModel(numberModel);
            
            if(rowIndex!=-1){
                for(JButton button : buttonsToEnableInSelection){
                button.setLocation(button.getX(), (rowIndex+1)*35);
                button.setVisible(true);
                }
                spinner.setLocation(spinner.getX(), (rowIndex+1)*35);
                spinner.setEnabled(true);
                spinner.setVisible(true);
            }else{
                for(JButton button : buttonsToEnableInSelection){
                    button.setEnabled(false);
                    button.setVisible(false);
                }
                spinner.setEnabled(false);
                spinner.setVisible(false);
            }
            
            
            
        }
    }
    
}
