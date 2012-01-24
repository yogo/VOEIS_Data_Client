/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Classes.Validation;
import java.util.Arrays;
import javax.swing.JFileChooser;

/**
 *
 * @author afannin1
 */
public class UploadModel {
    
    private String pushInterval;
    Validation validate = new Validation();
    public void setPushInterval(String interval) {
        pushInterval = interval;
    }
    
    public String getPushInterval() {
        return pushInterval;
    }

    public boolean validateText(String[] parentArray) {
        String[] inputArray = new String[parentArray.length];
        inputArray = copyArray(parentArray);
        //Check for nulls in array
        for (int i = 0; i < inputArray.length; i++)
            if (inputArray[i] == null)
                return false;
        if (validate.integerTextField(inputArray[0]) && validate.integerTextField(inputArray[1])
            && validate.integerTextField(inputArray[2]) && validate.integerTextField(inputArray[3]))
            return true;
        else
            return false;
    }

    private String[] copyArray(String[] parentArray) {
        String[] input = new String[parentArray.length];
        
        for (int i = 0; i < parentArray.length; i ++)
            input = Arrays.copyOf(parentArray, parentArray.length);
        return input;
    }
}
