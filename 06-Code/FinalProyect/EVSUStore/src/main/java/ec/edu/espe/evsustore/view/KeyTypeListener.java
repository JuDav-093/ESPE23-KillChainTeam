
package ec.edu.espe.evsustore.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class KeyTypeListener implements KeyListener{
    String TypeOfValidation;

    public KeyTypeListener(String TypeOfValidation) {
        this.TypeOfValidation = TypeOfValidation;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if(TypeOfValidation.equals("int")){
            validateTypedIntegerNumbers(e);
        }
        else if(TypeOfValidation.equals("Double")){
            validateTypedDoubleNumbers(e);
        }
        else if(TypeOfValidation.equals("char")){
            validateTypedCharacters(e);
        }
        else if(TypeOfValidation.equals("email")){
            validateTypedEmail(e);
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    private void validateTypedCharacters (java.awt.event.KeyEvent evt) { 
        char enteredChar = evt.getKeyChar ();  
        if (!Character.toString (enteredChar).matches ("[a-zA-ZáéíóúÁÉÍÓÚñÑ]")){
            evt.consume ();
        } 
    }
    
    private void validateTypedDoubleNumbers (java.awt.event.KeyEvent evt) { 
        
        char enteredChar = evt.getKeyChar ();
        if (!Character.toString (enteredChar).matches ("[0-9]") && !Character.toString (enteredChar).matches("\\.")) {
            evt.consume ();
        }
        else {
            JTextField field = (JTextField) evt.getSource ();
            String numbersText = field.getText ();
            if(numbersText!=null){
                if (numbersText.matches ("[0-9]{1,6}+\\.{1}[0-9]{2}")) {
                    evt.consume();
                    
                }
                else if(Character.toString (enteredChar).matches("\\.") && field.getText().contains(".") ){
                    evt.consume ();
                }
                else if(numbersText.matches("[0-9]{6}") && !Character.toString (enteredChar).matches("\\.")){
                    evt.consume();
                }
            }
            
        }
    }
    
    private void validateTypedIntegerNumbers (java.awt.event.KeyEvent evt) { 
        
        char enteredChar = evt.getKeyChar ();
        if (!Character.toString (enteredChar).matches ("[0-9]+")) {
            evt.consume ();
        }
        else{
            JTextField field = (JTextField) evt.getSource ();
            String numbersText = field.getText ();
            if(numbersText.matches("[0-9]{10}")){
                evt.consume ();
            }
            
        }
    }
    
    private void validateTypedEmail (java.awt.event.KeyEvent evt) { 
        
        char enteredChar = evt.getKeyChar ();
        JTextField field = (JTextField) evt.getSource ();
        String textEmail = field.getText();
        
        if(textEmail.contains("@")){
            if(Character.toString (enteredChar).matches("\\@")){
                evt.consume();
            }
        }
    }
    
}


