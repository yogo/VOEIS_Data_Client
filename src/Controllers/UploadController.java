/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.UploadModel;
import Views.MainView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author afannin1
 */
public class UploadController extends AbstractController{

    //public static final String TIME_INTERVAL = "interval";
    public static final String UPLOAD = "upload";
        
    UploadModel model;
    MainView view;
   
    @SuppressWarnings("LeakingThisInConstructor")
    public UploadController(UploadModel model, MainView view) {
        this.model = model;
        this.view = view;
        view.setActionListeners(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        boolean validationFlag = false;
//        if (TIME_INTERVAL.equals(action))
//        {
//            model.setPushInterval(view.intervalTextField.getText());
//            view.timeInterval = model.getPushInterval();
//        }
        if (UPLOAD.equals(action))
        {
                validationFlag = model.validateText(view.inputArr);
                if (validationFlag == true)
                {
                    //Call uploading methods here
                    JOptionPane.showMessageDialog(view, "Correct!");
                }
                else 
                    JOptionPane.showMessageDialog(view, "Some required fields were not filled out correctly.\nPlease try again.");
        }
    }
    
}
