package nonlineargradientsui;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Whenever one of the input fields changes, it sets a flag such that we 
 * know that the retention time needs to be recalculated 
 * 
 * @author Luminita Moruz
 */

class TextFieldListener implements DocumentListener {

    public TextFieldListener(RTPanel v) {
        panel = v;
    }

    @Override 
    public void changedUpdate(DocumentEvent e) {
        //System.out.println("ChangeUpdate");
        panel.setInputFieldsChanged(true);
        /* add listeners */
        
    }
     
    @Override
    public void removeUpdate(DocumentEvent e) {
        //System.out.println("RemoveUpdate");
        panel.setInputFieldsChanged(true);
    }
      
    @Override
    public void insertUpdate(DocumentEvent e) {
        //System.out.println("InsertUpdate");
        panel.setInputFieldsChanged(true);
    }

    private RTPanel panel; 
}
